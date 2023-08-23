package com.example.backup.contorller.user;

import com.example.backup.mapper.UserMapper;
import com.example.backup.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zzx
 * @date 2023/8/18 3:07
 */
@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    //index
    @GetMapping("/")
    public String index(){
        return "首页qwq";
    }


    @GetMapping("/user/all/")
    public List<User> getAll(){
        return userMapper.selectList(null);
    }

    @GetMapping("/user/{userId}/")
    public User getUser(@PathVariable int userId){
        return userMapper.selectById(userId);
    }

    //添加一条数据
    @GetMapping("/user/add/{userId}/{username}/{password}/")
    public String addUser(
            @PathVariable int userId,
            @PathVariable String username,
            @PathVariable String password)
    {
        //换成加密后的密码
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(userId,username,encodedPassword);
        userMapper.insert(user);

        return "Add User successfully!";
    }
    //删除一条数据
    @GetMapping("/user/delete/{userId}")
    public String deleteUser(@PathVariable int userId){
        userMapper.deleteById(userId);
        return "delete user Successfully~!";
    }
}
