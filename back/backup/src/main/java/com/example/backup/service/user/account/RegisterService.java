package com.example.backup.service.user.account;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/18 20:48
 */
public interface RegisterService {
    public Map<String,String> register(String username,String password,
                                       String confirmedPassword);
}
