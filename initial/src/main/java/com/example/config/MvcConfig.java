package com.example.config;

import com.example.view.JsonViewResolver;
import com.example.view.PdfViewResolver;
import com.example.view.XlsViewResolver;
import com.example.view.XmlViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tom on 2016/5/15.
 */
@Configuration
@ComponentScan("com.example")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {
    // 静态资源映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor());
    }

    //文件上传设置--在此处
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);//最大上传100Ｍ
        return multipartResolver;
    }

    // 在此---配置ContentNegotiationManager,在无后缀名情况下默认为jsp view resolver
    @Override
    public void configureContentNegotiation(
            ContentNegotiationConfigurer configurer) {
        configurer.ignoreAcceptHeader(true).defaultContentType(
                MediaType.TEXT_HTML);
    }

    //在此---jsp viewResolver
    /*@Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver resolver = new UrlBasedViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        return resolver;
    }*/
    // 在此---配置ContentNegotiatingViewResolver,通过此代理到不同的viewResolover
    @Bean
    public ViewResolver contentNegotiatingViewResolver(
            ContentNegotiationManager manager) {

        ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
        resolver.setContentNegotiationManager(manager);
        List<ViewResolver> resolvers = new ArrayList<ViewResolver>();

        resolvers.add(new XmlViewResolver());
        resolvers.add(new JsonViewResolver());
        // resolvers.add(viewResolver());// jsp view resolver
        resolvers.add(new PdfViewResolver());
        resolvers.add(new XlsViewResolver());
        resolver.setViewResolvers(resolvers);
        return resolver;
    }
}
