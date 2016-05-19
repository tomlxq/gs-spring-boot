package com.example;

/**
 * Created by tom on 2016/5/19.
 */

import com.example.domain.Log;
import com.example.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * 处理管理登录日志
 */
public class LoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Autowired
    private LogService logService;//日志记录Service

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        //创建日志对象
        Log log = new Log();
        log.setUserid(logService.loginUserId());//设置管理员id
        log.setCreatedate(new Date());//操作时间
        log.setContent("管理员 " + userDetails.getUsername());//操作内容
        log.setOperation("登录");//操作

        logService.log(log);//添加日志

        super.onAuthenticationSuccess(request, response, authentication);
    }

}
