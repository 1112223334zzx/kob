package org.example.botrunningsystem.service.impl;

import org.example.botrunningsystem.service.BotRunningService;
import org.example.botrunningsystem.service.impl.util.BotPool;
import org.springframework.stereotype.Service;

/**
 * @author zzx
 * @date 2023/8/24 22:59
 */
@Service
public class BotRunningServiceImpl implements BotRunningService {
    public final static BotPool botpool = new BotPool();
    @Override
    public String addBot(Integer userId, String botCode, String input) {
        System.out.println("add bot:" + userId+" code:" + botCode + " input:" + input);
        botpool.addBot(userId,botCode,input);
        return "add bot success";
    }
}
