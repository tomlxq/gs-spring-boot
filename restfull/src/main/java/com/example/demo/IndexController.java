package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tom on 2018/1/12.
 */
@RestController
@RequestMapping(value = "/index")
public class IndexController {
    @Value(value="${demo.secret}")
    private String secret;
    @Value(value="${demo.number}")
    private int number;
    @Value(value="${demo.name}")
    private String name;
    @RequestMapping
    public String index() {
        return "hello world";
    }
    //http://localhost:8080/index/get?name=zhangeshan
    @RequestMapping(value = "/get")
    public Map<String, String> get(@RequestParam String name) {
        Map<String, String> map = new HashMap();
        map.put("name", name);
        map.put("value", "hello world");
        return map;
    }
    //http://localhost:8080/index/find/1/luoxiaoqiang
    @RequestMapping(value = "/find/{id}/{name}")
    public User find(@PathVariable String id,@PathVariable String name) {
        User user = new User();
        user.setBirthday(new Date());
        user.setUsername(name);
        user.setPassword(secret);
        user.setAge(number);
        return user;
    }
}
