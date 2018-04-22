package com.example;

import com.example.dao.IClassDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests {
    Logger logger = LoggerFactory.getLogger(SpringBootMybatisApplicationTests.class);
    @Autowired
    IClassDao classDao;

    @Test
    public void contextLoads() {
        logger.info("{}", classDao.getClassByID(1));
    }

}
