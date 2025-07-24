//package com.maopi.usercenter.config;
//
//import com.maopi.usercenter.service.UserService;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//
//@Component
//public class UserRegistrationRunner implements CommandLineRunner {
//
//    @Resource
//    private UserService userService;
//
//    @Override
//    public void run(String... args) throws Exception {
//        // 设置默认用户信息
//        String userAccount = "maopi";
//        String userPassword = "mao123456";
//        String checkPassword = "mao123456"; // 确认密码
//        String planetCode = "1909";
//
//        // 调用注册方法
//        userService.userRegister(userAccount, userPassword, checkPassword, planetCode);
//    }
//}
