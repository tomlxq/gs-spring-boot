package com.example.demo.domain;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * 用户持久层操作接口
 * <p>
 * Created by tomlxq on 18/09/2017.
 */
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

}
