package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.vo.ConfigBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SelfConfigController {
    Logger logger=LoggerFactory.getLogger(SelfConfigController.class);
    @Autowired
    ConfigBean configBean;

    @RequestMapping(value = "/tom")
    public String tom() {
        logger.info("{}",configBean);
        logger.info("{}", JSON.toJSONString(configBean));
        return configBean.getGreeting() + " >>>>" + configBean.getName() + " >>>>" + configBean.getUuid() + " >>>>" + configBean.getMax();
    }
}