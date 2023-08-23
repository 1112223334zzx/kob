package org.example.matchingsystem.service;

/**
 * @author zzx
 * @date 2023/8/23 21:26
 */
public interface MatchingService {
    String addPlayer(Integer userId,Integer rating);
    String removePlayer(Integer userId);
}
