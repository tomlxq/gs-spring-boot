package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class HomeController {
    @RequestMapping(value = {"/", ""})
    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
