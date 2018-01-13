package com.example.demo.service.impl;

import com.example.demo.domain.UserValidRepository;
import com.example.demo.domain.ValidUser;
import com.example.demo.service.UserValidService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * User 业务层实现
 *
 * Created by bysocket on 24/07/2017.
 */
@Service
public class UserValidServiceImpl implements UserValidService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserValidServiceImpl.class);

    @Autowired
    UserValidRepository userRepository;

    @Override
    public List<ValidUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public ValidUser insertByValidUser(ValidUser user) {
        LOGGER.info("新增用户：" + user.toString());
        return userRepository.save(user);
    }

    @Override
    public ValidUser update(ValidUser user) {
        LOGGER.info("更新用户：" + user.toString());
        return userRepository.save(user);
    }

    @Override
    public ValidUser delete(Long id) {
        ValidUser user = userRepository.findOne(id);
        userRepository.delete(user);

        LOGGER.info("删除用户：" + user.toString());
        return user;
    }

    @Override
    public ValidUser findById(Long id) {
        LOGGER.info("获取用户 ID ：" + id);
        return userRepository.findOne(id);
    }
}
