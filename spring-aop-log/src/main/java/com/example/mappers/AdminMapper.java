package com.example.mappers;

/**
 * Created by tom on 2016/5/19.
 */

import com.example.domain.Admin;

/**
 * 管理员Mapper接口
 */
public interface AdminMapper {
    /**
     * 获取指定帐号名的管理员
     */
    Admin findAdminByNickname(String userName);
}
