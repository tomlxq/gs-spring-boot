package com.example;

/**
 * Created by tom on 2016/5/15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class SpringRestController {
    @Autowired
    UserDetails userDetails;

    @RequestMapping(value = "/xmlObj",
            method = RequestMethod.GET, produces = {"application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public UserDetails getUser() {
        UserDetails userDetails = new UserDetails();
        userDetails.setUserName("tom");
        userDetails.setEmailId("tomluo@gmail.com");
        return userDetails;
    }

    @RequestMapping(value = "/getJson", produces = {"application/json;charset=UTF-8"})
    public Account getJson(@RequestBody Account body) {
        return new Account(body.getName(), body.getPassword(), body.getEmail());
    }

    @RequestMapping(value = "/getXml", produces = {"application/xml;charset=UTF-8"})
    public Account getXml() {
        return new Account("tom", "123", "tomluo@gmail.com");
    }


}