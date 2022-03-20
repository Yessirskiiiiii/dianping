package com.threewater.utils;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/20/16:47
 * @Description:
 */
public interface ILock {
    /*
        尝试获取锁
        timeoutSec：锁持有的超时时间，过期后自动释放
     */
    boolean tryLock(long timeoutSec);
    // 释放锁
    void unLock();
}
