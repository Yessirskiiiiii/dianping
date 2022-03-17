package com.threewater.utils;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/17/19:33
 * @Description: 生成全局唯一ID
 */
@Component
public class RedisIdWorker {

    // 开始时间戳
    private static final Long BEGIN_TIMESTAMP = 1640995200L;
    // 序列号的位数 用于做位运算
    private static final int COUNT_BITS = 32;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    public long nextId(String keyPrefix) {
        // 1. 生成时间戳
        LocalDateTime now = LocalDateTime.now();
        long nowSecond = now.toEpochSecond(ZoneOffset.UTC);
        long timeStamp = nowSecond - BEGIN_TIMESTAMP;
        // 2. 生成序列号
        // 2.1 获取当前日期，精确到天
        String date = now.format(DateTimeFormatter.ofPattern("yyyy:MM:dd"));
        // 2.2 自增长
        long count = stringRedisTemplate.opsForValue().increment("icr:" + keyPrefix + ":" + date);// 每一天下的单使用相同的key
        // 3. 拼接并返回 使用位运算向左移动位数给序列号 使用或运算拼接count 0|1 = 1 0|0 = 0
        return timeStamp << COUNT_BITS | count;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.of(2022, 1, 1, 0, 0, 0);
        System.out.println(localDateTime.toEpochSecond(ZoneOffset.UTC));
    }

}
