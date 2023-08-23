package com.example.backup.contorller.user.account;

import com.example.backup.service.user.account.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/18 21:03
 */
@RestController
@RequestMapping("/user/account/")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping("/token/")
    public Map<String,String> getToken(@RequestParam Map<String,String> map){
        String username = map.get("username");
        String password = map.get("password");
        System.out.println("username:"+username+" "+ "password:" + password);
        return loginService.getToken(username,password);
    }

}
