package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * User: TOM
 * Date: 2016/5/20
 * email: beauty9235@gmail.com
 * Time: 9:19
 */
@Configuration
@ComponentScan(basePackages = {"com.example.web"}, useDefaultFilters = false, includeFilters = @Filter({Controller.class}))
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index");
        //添加更多
    }
}
