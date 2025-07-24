package com.maopi.usercenter.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/12 18:26 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
@SpringBootTest
public class RedisTest {
    @Resource
    private RedisTemplate redisTemplate;
    @Test
    void test()
    {
        ValueOperations valueOperations = redisTemplate.opsForValue();
        ListOperations listOperations = redisTemplate.opsForList();
        valueOperations.set("maopi","cat");
        valueOperations.set("maopiInt",123);
        valueOperations.set("maopiDouble",123.456);
        valueOperations.set("maopiBoolean",true);
        Object maopi = valueOperations.get("maopi");
        Assertions.assertTrue("cat".equals((String)maopi));
        Object maopiInt = valueOperations.get("maopiInt");
        Assertions.assertTrue(123==(Integer) maopiInt);
        Object maopiDouble = valueOperations.get("maopiDouble");
        Assertions.assertTrue(123.456==(Double) maopiDouble);
        Object maopiBoolean = valueOperations.get("maopiBoolean");
        Assertions.assertTrue(true==(Boolean) maopiBoolean);



    }
}