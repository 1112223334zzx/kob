package org.example.matchingsystem.controller;

import org.example.matchingsystem.service.impl.MatchingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zzx
 * @date 2023/8/23 21:29
 */
@RestController
public class MatchingController {
    @Autowired
    MatchingServiceImpl matchingService;

    @PostMapping("/player/add/")
    public String addPlayer(@RequestParam MultiValueMap<String,String> data){
        Integer user_id = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        Integer rating = Integer.parseInt(Objects.requireNonNull(data.getFirst("rating")));
        return matchingService.addPlayer(user_id,rating);
    }

    @PostMapping("/player/remove")
    public String removePlayer(@RequestParam MultiValueMap<String,String> data){
        Integer user_id = Integer.parseInt(Objects.requireNonNull(data.getFirst("user_id")));
        return matchingService.removePlayer(user_id);
    }

}
