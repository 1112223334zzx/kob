package com.example.backup.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backup.mapper.BotMapper;
import com.example.backup.pojo.Bot;
import com.example.backup.pojo.User;
import com.example.backup.service.user.bot.DeleteBotService;
import com.example.backup.utils.GetUserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/20 21:19
 */
@Service
public class DeleteBotServiceImpl implements DeleteBotService {
    @Autowired
    BotMapper botMapper;
    @Override
    public Map<String, String> deleteBot(Map<String, String> data) {

        Map<String,String> map = new HashMap<>();
        Bot bot = botMapper.selectById(data.get("id"));
        botMapper.deleteById(bot);
        map.put("error_message","delete success");
        return map;

    }
}
