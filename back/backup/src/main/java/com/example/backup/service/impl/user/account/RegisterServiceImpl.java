package com.example.backup.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backup.mapper.UserMapper;
import com.example.backup.pojo.User;
import com.example.backup.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/18 23:45
 */
@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword) {
        Map<String,String> map = new HashMap<>();
        if(username == null){
            map.put("error_message","用户名不能为空");
            return  map;
        }
        if(password == null || confirmedPassword == null){
            map.put("error_message","密码不能为空");
            return  map;
        }
        username = username.trim();
        if (username.length() == 0){
            map.put("error_message","用户名不能为空");
            return  map;
        }
        if (username.length() > 100){
            map.put("error_message","用户名长度不能大于100");
            return map;
        }

        if (!password.equals(confirmedPassword)){
            map.put("error_message","两次输入的密码不一致");
            return map;
        }

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);
        ArrayList<User> userList = (ArrayList<User>) userMapper.selectList(queryWrapper);
        if(!userList.isEmpty()){
            map.put("error_message","用户名已经存在");
            return map;
        }

        String encodePassword = passwordEncoder.encode(password);
        String photo = "https://cdn.acwing.com/media/user/profile/photo/74573_lg_a22269cc65.jpg";
        User user = new User(null,username,encodePassword,photo);
        userMapper.insert(user);
        map.put("error_message","success");
        return map;

    }
}
