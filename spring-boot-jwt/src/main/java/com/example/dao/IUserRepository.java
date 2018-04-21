package com.example.dao;

import com.example.entity.Role;
import com.example.entity.User;
import com.example.entity.UserRole;
import org.springframework.stereotype.Component;

/**
 * 需实现对用户表的增删改查，此处可采用任意数据库，具体实现自行编写
 */
@Component
public interface IUserRepository{

    /**
     * 通过用户名查找用户
     *
     * @param username 用户名
     * @return 用户信息
     */
    User findByUsername(String username);

    int insert(User user);

    int insertUserRole(UserRole ur);

    int insertRole(Role role);
}