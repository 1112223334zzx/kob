package com.example.backup.service.user.account;

import java.util.Map;

/**
 * @author zzx
 * @date 2023/8/18 20:47
 */
public interface LoginService {
    public Map<String,String> getToken(String username,String password);
}
