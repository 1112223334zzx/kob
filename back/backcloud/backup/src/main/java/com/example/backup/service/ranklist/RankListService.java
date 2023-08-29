package com.example.backup.service.ranklist;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zzx
 * @date 2023/8/29 23:16
 */
public interface RankListService {
    JSONObject getList(Integer page);
}
