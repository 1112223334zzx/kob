package com.example.backup.consumer.util;

import com.example.backup.utils.JwtUtil;
import io.jsonwebtoken.Claims;

/**
 * @author zzx
 * @date 2023/8/21 18:50
 */
public class JwtAuthentication {
    public static Integer getUserId(String token){
        int userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = Integer.parseInt(claims.getSubject());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userId;
    }
}
