package com.example.backup.service.impl.user.bot;

import com.example.backup.mapper.BotMapper;
import com.example.backup.pojo.Bot;
import com.example.backup.pojo.User;
import com.example.backup.service.user.bot.UpdateBotService;
import com.example.backup.utils.GetUserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/20 21:20
 */
@Service
public class UpdateBotServiceImpl implements UpdateBotService {

    @Autowired
    BotMapper botMapper;

    @Override
    public Map<String, String> updateBot(Map<String, String> data) {
        User user = GetUserInfoUtil.getUser();

        Bot bot =  botMapper.selectById(data.get("bot_id"));
        int bot_id = Integer.parseInt(data.get("bot_id"));
        String title = data.get("title");
        String description = data.get("description");
        String content = data.get("content");

        Map<String, String> map = new HashMap<>();
        if (title == null || title.isEmpty()) {
            map.put("error_message", "标题不能为空");
            return map;
        }

        if (title.length() > 100) {
            map.put("error_message", "标题长度不能大于100");
            return map;
        }

        if (description == null || description.isEmpty()) {
            description = "这个用户很懒，什么也没留下~";
        }

        if (description.length() > 300) {
            map.put("error_message", "Bot描述的长度不能大于300");
            return map;
        }

        if (content == null || content.length() == 0) {
            map.put("error_message", "代码不能为空");
            return map;
        }

        if (content.length() > 10000) {
            map.put("error_message", "代码长度不能超过10000");
            return map;
        }

        Bot new_bot = new Bot(
                bot.getId(),
                user.getId(),
                title,
                description,
                content,
                bot.getRating(),
                bot.getCreatetime(),
                new Date()
        );
        botMapper.updateById(new_bot);

        map.put("error_message", "success");

        return map;

    }
}
