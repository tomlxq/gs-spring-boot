package com.example.service;

/**
 * Created by tom on 2016/5/19.
 */

import com.example.domain.Admin;

/**
 * 管理员信息业务逻辑接口
 */
public interface AdminService {
    /**
     * 获取指定帐号名的管理员
     */
    Admin findAdminByNickname(String userName);
}
