package com.example.service;

/**
 * Created by tom on 2016/5/19.
 */

import com.example.domain.Log;
import org.springframework.transaction.annotation.Transactional;

/**
 * 日志记录业务逻辑接口
 */
public interface LogService {

    /**
     * 日志记录
     *
     * @param log
     */
    @Transactional
    void log(Log log);

    /**
     * 获取登录管理员ID
     */
    Long loginUserId();
}
