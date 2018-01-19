package com.example.springbootexception.web;

import com.example.springbootexception.constant.CityErrorInfoEnum;
import com.example.springbootexception.result.GlobalErrorInfoException;
import com.example.springbootexception.result.ResultBody;


import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 错误码案例
 *
 * Created by bysocket on 16/4/26.
 */
@RestController
public class ErrorJsonController {


    /**
     * 获取城市接口
     *
     * @param cityName
     * @return
     * @throws GlobalErrorInfoException
     */
    @RequestMapping(value = "/api/city", method = RequestMethod.GET)
    public ResultBody findOneCity(@RequestParam("cityName") String cityName) throws GlobalErrorInfoException {
        // 入参为空
        if (StringUtils.isEmpty(cityName)) {
            throw new GlobalErrorInfoException(CityErrorInfoEnum.PARAMS_NO_COMPLETE);
        }
        if(StringUtils.equals(cityName,"乐山")){
            throw new GlobalErrorInfoException(CityErrorInfoEnum.CITY_EXIT);
        }
        return new ResultBody(new City(1L,2L,"乐山","是我的故乡"));
    }
}