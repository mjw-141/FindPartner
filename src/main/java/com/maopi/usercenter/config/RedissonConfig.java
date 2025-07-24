package com.maopi.usercenter.config;

import lombok.Data;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author 毛嘉伟
 * @Date 2025/07/17 16:30 （可以根据需要修改）
 * @Version 1.0 （版本号）
 * Redission配置
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
@Data
public class RedissonConfig {
    private String host;
    private String port;

    @Bean
    public RedissonClient redissonClient() {
        //创建配置
        Config config = new Config();
        String redisAddress = String.format("redis://%s:%s", host, port);
//        config.useClusterServers()
//                // use "redis://" for Redis connection
//                // use "valkey://" for Valkey connection
//                // use "valkeys://" for Valkey SSL connection
//                // use "rediss://" for Redis SSL connection
//                .addNodeAddress("redis://127.0.0.1:7181");
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(3);

        //创建Redission实例
        //Sync and Async API
        RedissonClient redisson = Redisson.create(config);
        return redisson;

//        // Reactive API
//        RedissonReactiveClient redissonReactive = redisson.reactive();
//
//        // RxJava3 API
//        RedissonRxClient redissonRx = redisson.rxJava();
    }
}