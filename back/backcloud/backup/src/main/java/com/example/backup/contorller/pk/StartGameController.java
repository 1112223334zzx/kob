package com.example.backup.contorller.pk;

import com.example.backup.service.pk.StartGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * @author zzx
 * @date 2023/8/24 0:18
 */
@RestController
public class StartGameController {
    @Autowired
    StartGameService startGameService;

    @PostMapping("/pk/start/game/")
    public String startGame(@RequestParam MultiValueMap<String,String> data){
        Integer a = Integer.valueOf(Objects.requireNonNull(data.getFirst("a_id")));
        Integer b = Integer.valueOf(Objects.requireNonNull(data.getFirst("b_id")));
        return startGameService.startGame(a,b);
    }
}
