package com.example.springbootpermissioncontrol;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 第一步：从request获取token
 第二步：根据token获取校验对象信息（也可以加入过期时间校验，简单）
 第三步：通过校验信息获取用户信息
 */
@Component
public class AccessTokenVerifyInterceptor extends HandlerInterceptorAdapter {

   // @Autowired
    //ValidationService validationService;

    private final static Logger LOG = LoggerFactory.getLogger(AccessTokenVerifyInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        LOG.info("AccessToken executing ...");
        boolean flag = false;
        // token
        String accessToken = request.getParameter("token");
        if (StringUtils.isNotBlank(accessToken)) {
            // 验证
          //  ValidationModel v = validationService.verifyAccessToken(accessToken);
            // 时间过期

            // 用户验证
           // if (v != null) {
            //    User user = userService.findById(v.getUid());
            //    if(user != null) {
             //       request.setAttribute(CommonConst.PARAM_USER, user);
                  //  LOG.info("AccessToken SUCCESS ...  user:" + user.getUserName() + " - " + accessToken);
                    flag = true;
               // }
           // }
        }

        if (!flag) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            response.getWriter().print("AccessToken ERROR");
        }

        return flag;
    }
}
