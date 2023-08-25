package com.example.backup.service.impl.pk;

import com.example.backup.consumer.WebSocketServer;
import com.example.backup.consumer.util.Game;
import com.example.backup.service.pk.ReceiveBotMoveService;
import org.springframework.stereotype.Service;

/**
 * @author zzx
 * @date 2023/8/26 0:42
 */
@Service
public class ReceiveBotMoveServiceImpl implements ReceiveBotMoveService {
    @Override
    public String receiveBotMove(Integer userId, Integer direction) {
        System.out.println("receive bot move:" + userId + " " + direction);

        if (WebSocketServer.users.get(userId) != null){
            Game game = WebSocketServer.users.get(userId).game;
            if (game != null){
                if (game.getPlayerA().getId().equals(userId)) {
                    game.setNextStepA(direction);
                } else if (game.getPlayerB().getId().equals(userId)) {
                    game.setNextStepB(direction);
                }
            }
        }

        return "receive bot move success";
    }
}
