package com.example.demo.service;


import com.example.demo.domain.User;

import java.util.List;

/**
 * User 业务层接口
 * <p>
 * Created by tomlxq on 24/07/2017.
 */
public interface UserService {

    List<User> findAll();

    User insertByUser(User user);

    User update(User user);

    User delete(Long id);

    User findById(Long id);
}
