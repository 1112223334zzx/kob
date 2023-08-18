package com.example.backup.contorller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zzx
 * @date 2023/8/18 2:46
 */
@RequestMapping("/pk")
@Controller
public class IndexController {
    @RequestMapping("/index")
    public String index(){
        return "pk/index.html";
    }
}
