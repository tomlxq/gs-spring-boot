package com.example;

/**
 * Created by tom on 2016/5/15.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringRestControllerDemo {
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


}