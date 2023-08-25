package org.example.botrunningsystem.service.impl.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zzx
 * @date 2023/8/25 2:26
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bot {
    Integer userId;
    String botCode;
    String input;
}
