package com.example.web;

import com.example.model.Person;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.*;

/**
 * User: TOM
 * Date: 2016/5/20
 * email: beauty9235@gmail.com
 * Time: 13:16
 */
@Controller
public class PersonController {
    @RequestMapping("/person")
    public
    @ResponseBody
    Person showPerson() {
        return new Person("tomLuo", "tomluo@gmail.com");
    }
}