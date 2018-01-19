package com.example.springbootpermissioncontrol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MVC 设置
 *
 第一步：将拦截器配置成Bean
 第二步：拦截器注册注入该拦截器，并配置拦截的URL
 第三步：token存哪里,ehcache，redis，db都可以。自然简单的当然是db。
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Bean
    public AccessTokenVerifyInterceptor tokenVerifyInterceptor() {
        return new AccessTokenVerifyInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenVerifyInterceptor()).addPathPatterns("/test");
        super.addInterceptors(registry);
    }

}