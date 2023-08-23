package com.example.backup.mapper;

/**
 * @author zzx
 * @date 2023/8/23 17:49
 */

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backup.pojo.Record;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RecordMapper extends BaseMapper<Record> {
}
