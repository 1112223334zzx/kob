package org.example.matchingsystem;

import org.example.matchingsystem.service.impl.MatchingServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zzx
 * @date 2023/8/23 21:16
 */
@SpringBootApplication
public class MatchingSystemApplication {
    public static void main(String[] args) {
        MatchingServiceImpl.matchingpool.start();//启动匹配线程
        SpringApplication.run(MatchingSystemApplication.class,args);
    }
}