package com.example.backup.contorller;

/**
 * @author zzx
 * @date 2023/8/15 5:09
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/pk")
public class BotInfoController {
    @RequestMapping("/bot")
    public Map<String,String> getInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("name","张三");
        map.put("ratings","1200");
        return map;
     }
}
