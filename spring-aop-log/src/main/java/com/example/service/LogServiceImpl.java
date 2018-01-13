package com.example.service;

/**
 * Created by tom on 2016/5/19.
 */

import com.example.domain.Admin;
import com.example.domain.Log;
import com.example.mappers.LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 日志记录业务逻辑接口实现类
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private AdminService adminService;

    @Autowired
    private LogMapper logMapper;

    public void log(Log log) {
        logMapper.insertLog(log);
    }

    /**
     * 获取登录管理员ID
     *
     * @return
     */
    public Long loginUserId() {

       // if (SecurityContextHolder.getContext() == null) {
       //     return null;
       // }

       // if (SecurityContextHolder.getContext().getAuthentication() == null) {
       //     return null;
       // }

      //  UserDetails userDetails = (UserDetails) SecurityContextHolder
       //         .getContext().getAuthentication().getPrincipal();

       // if (userDetails == null) {
       //     return null;
       // }

        //获取登录管理员帐号名
        String userName = "tomLuo";//userDetails.getUsername();

        if (userName == null || userName.equals("")) {
            return null;
        }

        // 根据管理员帐号名获取帐号ID
        Admin admin = this.adminService.findAdminByNickname(userName);

        if (admin == null) {
            return null;
        }

        return admin.getId();
    }
}
