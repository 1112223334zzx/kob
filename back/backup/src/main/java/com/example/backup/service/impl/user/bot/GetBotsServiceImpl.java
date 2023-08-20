package com.example.backup.service.impl.user.bot;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.backup.mapper.BotMapper;
import com.example.backup.pojo.Bot;
import com.example.backup.pojo.User;
import com.example.backup.service.user.bot.GetBotsService;
import com.example.backup.utils.GetUserInfoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zzx
 * @date 2023/8/20 21:20
 */
@Service
public class GetBotsServiceImpl implements GetBotsService {
    @Autowired
    private BotMapper botMapper;
    @Override
    public List<Bot> getBots() {
        User user = GetUserInfoUtil.getUser();
        QueryWrapper<Bot> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id",user.getId());

        return botMapper.selectList(queryWrapper);
    }
}
