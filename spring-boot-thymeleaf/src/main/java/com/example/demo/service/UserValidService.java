package com.example.demo.service;





import com.example.demo.domain.ValidUser;

import java.util.List;

/**
 * User 业务层接口
 *
 * Created by tomlxq on 24/07/2017.
 */
public interface UserValidService {

    List<ValidUser> findAll();

    ValidUser insertByValidUser(ValidUser user);

    ValidUser update(ValidUser user);

    ValidUser delete(Long id);

    ValidUser findById(Long id);
}
