package com.hmdp.config;

import com.hmdp.utils.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: Yessirskiii
 * @Date: 2022/03/10/20:09
 * @Description:
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .excludePathPatterns(
                        "/shop-type/**",
                        "/shop/**",
                        "/blog/hot",
                        "/user/code",
                        "/user/login",
                        "/voucher/**",
                        "/upload/**"
                );
    }
}
