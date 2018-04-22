package com.example.dao;

import com.example.vo.ClazzEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface IClassDao {
    ClazzEntity getClassByID(Integer id);
}
