package com.threewater.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.threewater.dto.LoginFormDTO;
import com.threewater.dto.Result;
import com.threewater.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Yessirskiii
 * @since 2021-12-22
 */
public interface IUserService extends IService<User> {

    Result sendCode(String phone, HttpSession session);

    Result login(LoginFormDTO loginForm, HttpSession session);

    Result sign();

    Result signCount();
}
