package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    public static Connection getConn() throws IOException, TimeoutException {
        ConnectionFactory factory=new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setVirtualHost("tom-site");
        factory.setUsername("tom");
        factory.setPassword("tom123");
        Connection conn=factory.newConnection();
        return conn;
    }
    @Test
    public void contextLoads() throws IOException, TimeoutException {
        if(getConn()!=null){
            System.out.println("OK");
        }
    }

}
