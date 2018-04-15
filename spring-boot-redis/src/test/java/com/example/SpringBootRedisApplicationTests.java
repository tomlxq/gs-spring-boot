package com.example;

import com.example.dao.RedisDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {


    public static Logger logger= LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);
    @Test
    public void contextLoads() {
    }

    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis(){
        redisDao.setKey("name","tom");
        redisDao.setKey("age","11");
        logger.info(redisDao.getValue("name"));
        logger.info(redisDao.getValue("age"));
    }
    @Test
    public void testJds(){
        Jedis jedis = new Jedis("localhost");
        System.out.println("Connection to server sucessfully");
        //check whether server is running or not
        System.out.println("Server is running: "+jedis.ping());
        jedis.lpush("tom-list", "Redis");
        jedis.lpush("tom-list", "Mongodb");
        jedis.lpush("tom-list", "Mysql");
        // Get the stored data and print it
        List<String> list = jedis.lrange("tom-list", 0 ,5);
        for(int i=0; i<list.size(); i++) {
            System.out.println("Stored string in redis:: "+list.get(i));
        }
    }
}


