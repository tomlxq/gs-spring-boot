package com.example;

import com.example.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class ContentController {
    @RequestMapping(value = "/content", method = RequestMethod.GET)
    public String content(Model model) {
        return "content";
    }

    @RequestMapping(value = "/getContent", method = RequestMethod.GET)
    public String getDemo(Model model) {
        Account account = new Account("tom", "123", "QQ@gmail.com");
        model.addAttribute("account", account);
        return "getContent";
    }

}
