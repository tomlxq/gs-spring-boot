package com.example.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDao {
    int update(@Param("money") double money, @Param("id") int  id);
}