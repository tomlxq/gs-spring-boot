package com.example.mappers;

/**
 * Created by tom on 2016/5/19.
 */


import com.example.domain.Log;

/**
 * 日志记录Mapper
 */
public interface LogMapper {

    Long insertLog(Log log);//添加日志记录

    Log findLogById(Long id);
}
