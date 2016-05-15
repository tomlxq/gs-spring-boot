package com.example.web;

import com.example.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class ConverterController {//

    @RequestMapping(value = "/convert", produces = {"application/x-tom"})
    public
    @ResponseBody
    Person convert(@RequestBody Person person) {
        return person;
    }
}
