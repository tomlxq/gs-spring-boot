package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@RestController
@RequestMapping("/")
@SpringBootApplication
public class EurekaClent2Application {
    @Value("${server.port}")
    String port;
    @RequestMapping("/hello")
    public String hello(@RequestParam String name){
        return String.format("hello %s,server.port=%s",name,port);
    }
    public static void main(String[] args) {
        SpringApplication.run(EurekaClent2Application.class, args);
    }
}
