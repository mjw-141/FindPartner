package com.maopi.usercenter.service;

import com.maopi.usercenter.mapper.UserMapper;
import com.maopi.usercenter.model.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;


/**
 * @Author 毛嘉伟
 * @Date 2025/07/04 19:24 （可以根据需要修改）
 * @Version 1.0 （版本号）
 */
@RunWith(SpringRunner.class) // 启用 Spring 测试支持
@SpringBootTest
public class InsertUserTest {


    // CPU 密集型：分配的核心线程数 = CPU - 1
    // IO 密集型：分配的核心线程数可以大于 CPU 核数
    //ArrayBlockingQueue<>(10000)：这是一个使用数组实现的有界阻塞队列，容量为10000。这意味着当提交给线程池的任务数量超过当前正在运行的任务数加上队列容量,新的任务将会根据线程池的拒绝策略进行处理。
    private ExecutorService executorService = new ThreadPoolExecutor( 40,1000,10000,TimeUnit.MINUTES, new ArrayBlockingQueue<>(10000));
        @Resource
        private UserService userService;
//        @Resource
//        private UserMapper userMapper;

        @Test
        public void doInsertUsers(){
            StopWatch stopWatch = new StopWatch();//统计运行时间
            stopWatch.start();

            List userList = new ArrayList<>();
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
                //userMapper.insert(user);
                userList.add(user);
            }
            userService.saveBatch(userList, 100);//mybatis-plus批量插入
            stopWatch.stop();
            System.out.println(stopWatch.getTotalTimeMillis());


        }
    //并发插入 100,000 条用户数据到数据库中，使用 Java 的 CompletableFuture 实现异步并发操作。并发，宏观上一起执行，微观上交替执行
    @Test
    public void doConcurrentInsertUsers() {
        StopWatch stopWatch = new StopWatch();//统计运行时间
        stopWatch.start();
        final int batchsize = 5000;
        int j = 0;
        List<CompletableFuture<Void>> futureList = new ArrayList<>();//futureList 用来保存所有的异步任务对象，方便后续等待所有任务完成
        //尽管 for 循环是线性执行的，但是每次循环通过 CompletableFuture.runAsync(...) 提交的任务会被放入一个线程池中等待执行。
        //这些任务并不立即执行，而是根据线程池的状态和可用资源来决定何时开始执行。
        //因此，虽然 for 循环是线性的，但多个通过 runAsync(...) 提交的任务可以并行执行，从而实现并发处理的效果。
        for (int i = 0; i < 20; i++) {
            List<User> userList = Collections.synchronizedList(new ArrayList<>());//线程安全的 ArrayList，用来存放每个线程要插入的一批用户数据。
            while (true) {
                j++;
                User user = new User();
                user.setUsername("假鱼皮");
                user.setUserAccount("fakeyupi");
                user.setAvatarUrl("https://636f-codenav-8qrij8px72756517-13194210.tcb.qcloud.la/img/logo.png");
                user.setGender(0);
                user.setUserPassword("12345678");
                user.setPhone("123");
                user.setEmail("123@qq.com");
                user.setTags("[1]");
                user.setUserStatus(0);
                user.setUserRole(0);
                user.setPlanetCode("11111111");

                userList.add(user);

                if (j % batchsize == 0) {
                    break;
                }
            }
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                System.out.println("开始插入：" + Thread.currentThread().getName());
                userService.saveBatch(userList, 10000);
            },executorService);
            //每次循环中，都是先执行完 while 循环（构造数据），然后再提交异步任务（插入数据）。所以在 第 2 次循环 中：
            // 先执行 while 循环，把第二批数据准备好；然后再调用 runAsync(...) 提交一个异步任务去插入这批数据；
            // 这个异步任务什么时候真正开始执行，取决于线程池调度。

            //构造数据是顺序的；
            //插入数据库是异步、并发的

            //写完一张后，你就把它交给打印机打印（相当于提交异步任务）；
            //打印机有多个打印头（相当于线程池），可以同时打印多张幻灯片；
            //你继续写第二张幻灯片，而打印机已经在打印第一张了。
            futureList.add(future);
        }
        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[]{})).join();
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeMillis());
    }
}