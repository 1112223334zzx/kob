package com.example.backup.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.backup.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zzx
 * @date 2023/8/18 3:04
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
