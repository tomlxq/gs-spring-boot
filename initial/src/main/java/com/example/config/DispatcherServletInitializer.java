package com.example.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * Created by tom on 2016/5/15.
 */
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[]{MvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[0];
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        FilterRegistration.Dynamic characterEncoding = servletContext.addFilter("characterEncoding", CharacterEncodingFilter.class);
        characterEncoding.setInitParameter("forceEncoding", "true");
        characterEncoding.setInitParameter("encoding", "UTF-8");
        characterEncoding.addMappingForUrlPatterns(null, true, "/*");
        servletContext.addFilter("characterEncoding", ResourceUrlEncodingFilter.class).addMappingForUrlPatterns(null, true, "/*");
    }
}
