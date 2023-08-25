package org.example.matchingsystem.service.impl;

import org.example.matchingsystem.service.MatchingService;
import org.example.matchingsystem.utils.MatchingPool;
import org.springframework.stereotype.Service;

/**
 * @author zzx
 * @date 2023/8/23 21:28
 */
@Service
public class MatchingServiceImpl implements MatchingService {

    public final static MatchingPool matchingpool = new MatchingPool();

    @Override
    public String addPlayer(Integer userId, Integer rating,Integer botId) {
        System.out.println("add player:" + userId + " " + rating);
        matchingpool.addPlayer(userId,rating,botId);
        return "add player success";
    }

    @Override
    public String removePlayer(Integer userId) {
        System.out.println("remove player:" + userId);
        matchingpool.removePlayer(userId);
        return "remove player success";
    }
}
