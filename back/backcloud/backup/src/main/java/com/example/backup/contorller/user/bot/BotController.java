package com.example.backup.contorller.user.bot;

import com.example.backup.pojo.Bot;
import com.example.backup.service.impl.user.bot.AddBotServiceImpl;
import com.example.backup.service.impl.user.bot.DeleteBotServiceImpl;
import com.example.backup.service.impl.user.bot.GetBotsServiceImpl;
import com.example.backup.service.impl.user.bot.UpdateBotServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/20 21:32
 */
@RestController
@RequestMapping("/user/bot/")
public class BotController {
    @Autowired
    AddBotServiceImpl addBotService;
    @Autowired
    DeleteBotServiceImpl deleteBotService;
    @Autowired
    UpdateBotServiceImpl updateBotService;
    @Autowired
    GetBotsServiceImpl getBotsService;

    @RequestMapping("add/")
    public Map<String,String> addBot(@RequestParam Map<String,String> data){
        return addBotService.addBot(data);
    }
    @RequestMapping("delete/")
    public Map<String,String> deleteBot(@RequestParam Map<String,String> data){
        return deleteBotService.deleteBot(data);
    }
    @RequestMapping("update/")
    public Map<String,String> updateBot(@RequestParam Map<String,String> data){
        return updateBotService.updateBot(data);
    }
    @RequestMapping("getlist/")
    public List<Bot> getBots(){
        return getBotsService.getBots();
    }
}
