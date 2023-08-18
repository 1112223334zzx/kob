package com.example.backup.contorller.user.account;

import com.example.backup.service.impl.user.account.InfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/18 22:36
 */
@RestController
public class InfoController {
    @Autowired
    private InfoServiceImpl infoService;

    @GetMapping("/user/account/info/")
    public Map<String,String> getinfo(){
        return infoService.getinfo();
    }
}
