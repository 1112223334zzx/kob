package org.example.botrunningsystem;

import org.example.botrunningsystem.service.impl.BotRunningServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zzx
 * @date 2023/8/24 22:41
 */
@SpringBootApplication
public class BotRunningApplication {
    public static void main(String[] args) {
        BotRunningServiceImpl.botpool.start();
        SpringApplication.run(BotRunningApplication.class);
    }
}