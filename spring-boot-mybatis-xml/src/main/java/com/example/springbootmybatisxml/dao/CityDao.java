package com.example.springbootmybatisxml.dao;

import org.apache.ibatis.annotations.Param;
import com.example.springbootmybatisxml.domain.City;

/**
 * 城市 DAO 接口类
 *
 * Created by tomlxq on 07/02/2017.
 */
public interface CityDao {

    /**
     * 根据城市名称，查询城市信息
     *
     * @param cityName 城市名
     */
    City findByName(@Param("cityName") String cityName);
}