package com.example.demo.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.example.demo.domain.User;
import com.example.demo.domain.UserRepository;
import com.example.demo.service.UserService;

/**
 * User 业务层实现
 *
 * Created by tomlxq on 18/09/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> findByPage(Pageable pageable) {
        LOGGER.info(" \n 分页查询用户："
                + " PageNumber = " + pageable.getPageNumber()
                + " PageSize = " + pageable.getPageSize());
        return userRepository.findAll(pageable);
    }

    @Override
    public User insertByUser(User user) {
        LOGGER.info("新增用户：" + user.toString());
        return userRepository.save(user);
    }
}
