package com.maopi.usercenter.once;
import java.util.Date;

import com.maopi.usercenter.mapper.UserMapper;
import com.maopi.usercenter.model.domain.User;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


import javax.annotation.Resource;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/04 17:35 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
@Component
public class InsertUsers {
    @Resource
    private UserMapper userMapper;

    //@Scheduled(initialDelay = 5000,fixedRate = Long.MAX_VALUE)
    public void doInsertUsers(){
        StopWatch stopWatch = new StopWatch();//统计运行时间
        stopWatch.start();

        final int INSERT_NUM = 1000;
        for (int i = 0; i < INSERT_NUM; i++){
            User user = new User();
            user.setUsername("假用户");
            user.setUserAccount("fakemaopi");
            user.setAvatarUrl("https://ts3.tc.mm.bing.net/th/id/OIP-C.OUpaDpZDdqpJb6A9j61KywAAAA?w=80&h=80&c=1&bgcl=a6ee63&r=0&o=6&dpr=1.5&pid=ImgRC");
            user.setGender(0);
            user.setUserPassword("12345678");
            user.setPhone("123");
            user.setEmail("123@qq.com");
            user.setTags("[]");
            user.setUserStatus(0);
            user.setUserRole(0);
            user.setPlanetCode("11111111");
            userMapper.insert(user);
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());


    }
}