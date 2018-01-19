package com.example.springbootmybatisxml.service.impl;

import com.example.springbootmybatisxml.dao.CityDao;
import com.example.springbootmybatisxml.domain.City;
import com.example.springbootmybatisxml.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 城市业务逻辑实现类
 *
 * Created by tomlxq on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }

}
