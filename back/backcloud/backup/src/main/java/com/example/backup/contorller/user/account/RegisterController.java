package com.example.backup.contorller.user.account;

import com.example.backup.service.impl.user.account.RegisterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/19 0:00
 */
@RestController
public class RegisterController {
    @Autowired
    private RegisterServiceImpl registerService;

    @PostMapping("/user/account/register")
    public Map<String,String> register(@RequestParam Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        return registerService.register(username,password,confirmedPassword);
    }
}
