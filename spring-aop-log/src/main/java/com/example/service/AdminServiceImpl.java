package com.example.service;

import com.example.domain.Admin;
import com.example.mappers.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tom on 2016/5/19.
 * 日志记录POJO
 */
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;//Mapper接口

    public Admin findAdminByNickname(String userName) {
        return adminMapper.findAdminByNickname(userName);
    }
}
