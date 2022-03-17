package com.threewater.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/15/19:17
 * @Description:
 */
@Data
@AllArgsConstructor
public class RedisData {
    private LocalDateTime expireTime;
    private Object data;
}
