package com.example.demo.dao;

/**
 * Created by tom on 2018/3/30.
 */


import com.example.demo.vo.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUserDao {

    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void insert(UserEntity user);

    void update(UserEntity user);

    void delete(Long id);

    void deleteAllData();
}