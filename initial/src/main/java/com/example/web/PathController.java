package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class PathController {
    //http://localhost:8080/configPath/tomLuo.home
    //request value:tomLuo
    @RequestMapping("/configPath/{test}")
    public
    @ResponseBody
    String configPath(@PathVariable String test) {
        return "request value:" + test;
    }
}
