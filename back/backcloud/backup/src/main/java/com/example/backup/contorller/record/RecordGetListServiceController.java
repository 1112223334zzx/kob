package com.example.backup.contorller.record;

import com.alibaba.fastjson.JSONObject;
import com.example.backup.service.record.RecordGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/29 16:08
 */
@RestController
public class RecordGetListServiceController {
    @Autowired
    RecordGetListService recordGetListService;
    @GetMapping("/record/getlist/")
    public JSONObject getList(@RequestParam Map<String,String>data){
        Integer page = Integer.valueOf(data.get("page"));
        return recordGetListService.getList(page);
    }

}
