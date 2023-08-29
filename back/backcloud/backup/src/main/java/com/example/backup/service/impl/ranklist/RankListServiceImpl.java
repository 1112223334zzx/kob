package com.example.backup.service.impl.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backup.mapper.UserMapper;
import com.example.backup.pojo.User;
import com.example.backup.service.ranklist.RankListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzx
 * @date 2023/8/29 23:17
 */
@Service
public class RankListServiceImpl implements RankListService {
    @Autowired
    UserMapper userMapper;
    @Override
    public JSONObject getList(Integer page) {
        IPage<User> userIPage = new Page<>(page,3);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("rating");
        List<User> users = userMapper.selectPage(userIPage,queryWrapper).getRecords();
        for(User user:users)
            user.setPassword("");
        JSONObject resp = new JSONObject();
        resp.put("users",users);
        resp.put("users_count",userMapper.selectCount(null));

        return resp;
    }
}
