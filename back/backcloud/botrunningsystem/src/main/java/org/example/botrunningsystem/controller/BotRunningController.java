package org.example.botrunningsystem.controller;

import org.example.botrunningsystem.service.BotRunningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zzx
 * @date 2023/8/24 23:00
 */
@RestController
public class BotRunningController {
    @Autowired
    BotRunningService botRunningService;
    @PostMapping("/bot/add/")
    String addBot(@RequestParam MultiValueMap<String,String> data){
        System.out.println("controller0.0");
        Integer userId = Integer.valueOf(Objects.requireNonNull(data.getFirst("user_id")));
        String botCode = data.getFirst("bot_code");
        String input = data.getFirst("input");
        return botRunningService.addBot(userId,botCode,input);
    }
}
