package com.example.backup.service.impl.record;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.backup.mapper.RecordMapper;
import com.example.backup.mapper.UserMapper;
import com.example.backup.pojo.Record;
import com.example.backup.pojo.User;
import com.example.backup.service.record.RecordGetListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zzx
 * @date 2023/8/29 16:07
 */
@Service
public class RecordGetListServiceImpl implements RecordGetListService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    RecordMapper recordMapper;

    @Override
    public JSONObject getList(Integer page) {
        IPage<Record> recordIPage = new Page<>(page,10);
        QueryWrapper<Record> recordQueryWrapper = new QueryWrapper<>();
        recordQueryWrapper.orderByDesc("id");//将record数据库表按照id降序排列 也就是每次新创建的record会在第一行显示
        List<Record> records = recordMapper.selectPage(recordIPage,recordQueryWrapper).getRecords();
        List<JSONObject> items = new LinkedList<>();
        JSONObject resp = new JSONObject();
        for(Record record:records){
            User userA = userMapper.selectById(record.getAId());
            User userB = userMapper.selectById(record.getBId());
            JSONObject item = new JSONObject();
            item.put("a_photo",userA.getPhoto());
            item.put("b_photo",userB.getPhoto());
            item.put("a_username",userA.getUsername());
            item.put("b_username",userB.getUsername());
            //在后端判断谁赢
            String result = "平局";
            if ("A".equals(record.getLoser())) result = "B胜";
            else if ("B".equals(record.getLoser())) result = "A胜";
            item.put("result",result);
            item.put("record",record);
            items.add(item);
        }
        resp.put("records",items);
        resp.put("record_count",recordMapper.selectCount(null));
        return resp;
    }
}
