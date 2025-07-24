package com.maopi.usercenter.service;

import org.junit.jupiter.api.Test;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/17 17:23 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */

public class RedissionTest {
    @Resource
    private RedissonClient redissonClient;

    @Test
    void test() {
        //list 本地jvm内存里
        List<String> list = new ArrayList<>();
        list.add("maopi");
        list.get(0);
        System.out.println("list:"+list.get(0));
        //list.remove(0);

        //数据存在redis内存中
        RList<String> rlist = redissonClient.getList("test-list");
        rlist.add("maopi");
        rlist.get(0);
        System.out.println("rlist:"+rlist.get(0));
        //rlist.remove(0);


        //map
        Map<String, Integer> map = new HashMap<>();
        map.put("mappi", 10);
        map.get("maopi");

        RMap<Object, Object> map1 = redissonClient.getMap("test-map");
        //set
    }
}