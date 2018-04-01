package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户持久层操作接口
 * <p>
 * Created by tomlxq on 21/07/2017.
 */
public interface UserValidRepository extends JpaRepository<ValidUser, Long> {


}
