package com.parameter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 杨森霖
 * @author 2020/8/20 0020 下午 15:22
 */
@Configurable
public class SignAttrInterceptor implements WebMvcConfigurer {


    @Autowired
    private VerifyInterceptor verifyInterceptor;


    //自定义拦截器，拦截管理员用户，添加新权限
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(verifyInterceptor).addPathPatterns("/do/*");
    }

}
