package org.example.botrunningsystem.service;

/**
 * @author zzx
 * @date 2023/8/24 22:58
 */
public interface BotRunningService {
    String addBot(Integer userId,String botCode,String input);//input:表示地图形状、蛇的形状、蛇走过的地方等
}
