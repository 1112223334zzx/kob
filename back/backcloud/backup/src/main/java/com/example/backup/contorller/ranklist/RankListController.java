package com.example.backup.contorller.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.example.backup.service.ranklist.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zzx
 * @date 2023/8/29 23:18
 */
@RestController
public class RankListController {
    @Autowired
    RankListService rankListService;
    @GetMapping("/rank/getlist/")
    public JSONObject getRankList(@RequestParam Integer page){
        return rankListService.getList(page);
    }
}
