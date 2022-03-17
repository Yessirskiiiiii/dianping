package com.threewater.config;

import com.threewater.utils.LoginInterceptor;
import com.threewater.utils.RefreshInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/10/20:09
 * @Description:
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 登录拦截器
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/shop-type/**",
                        "/shop/**",
                        "/blog/hot",
                        "/user/code",
                        "/user/login",
                        "/voucher/**",
                        "/upload/**"
                ).order(1);
        // token刷新拦截器
        registry.addInterceptor(new RefreshInterceptor(stringRedisTemplate)).addPathPatterns("/**").order(0);
    }
}
