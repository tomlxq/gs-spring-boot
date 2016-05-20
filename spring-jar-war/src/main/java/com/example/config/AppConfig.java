package com.example.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
/**
 * User: TOM
 * Date: 2016/5/20
 * email: beauty9235@gmail.com
 * Time: 11:12
 */
@Configuration
@ComponentScan(basePackages = { "com.example" }, excludeFilters = {
        @ComponentScan.Filter(pattern = {"com.example.web.*"}, type = FilterType.REGEX)

})
@PropertySource(value = { "classpath:application.yml" })
public class AppConfig
{
    @Autowired
    private Environment env;
}
