package com.maopi.usercenter.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.maopi.usercenter.mapper.UserMapper;
import com.maopi.usercenter.model.domain.User;
import com.maopi.usercenter.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/14 19:46 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
@Component
@Slf4j//使用log对象
public class preCacheJob {
    @Resource
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Resource
    private RedissonClient redissionClient;

    //重点用户
    private List<Long> mainUserList= Arrays.asList(1L);


    //每天执行，预热推荐用户
    @Scheduled(cron = "0 35 17 * * *")
    public void doCacheRecommendUser(){
        RLock lock=redissionClient.getLock("maopi:precachejob:docache:%s");

        try {//等待时间，没抢到就不等待；锁过期时间；尝试获取锁的次数
            if (lock.tryLock(0, 30000L, TimeUnit.MILLISECONDS)) {
                System.out.println("getlock:"+Thread.currentThread().getId());
                for (Long userId : mainUserList) {
                    QueryWrapper<User> queryWrapper = new QueryWrapper<>();
                    Page<User> userPage = userService.page(new Page<>(1, 20), queryWrapper);
                    String rediskey = String.format("maopi:user:recommend:%s", userId);
                    ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
                    //写缓存
                    try {
                        valueOperations.set(rediskey, userPage, 300000, TimeUnit.MILLISECONDS);
                    } catch (Exception e) {
                        log.error("redis set key error", e);
                    }
                }
            }
        } catch (InterruptedException e) {
            log.error("doCacheRecommendUser error", e);
        } finally{
            //只能释放自己的锁
            if(lock.isHeldByCurrentThread()){
                System.out.println("unlock:"+Thread.currentThread().getId());
                lock.unlock();
            }
        }
    }
}