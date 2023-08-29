package com.example.backup.service.record;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zzx
 * @date 2023/8/29 16:07
 */
public interface RecordGetListService {
    JSONObject getList(Integer page);
}
