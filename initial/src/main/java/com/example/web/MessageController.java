package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;

/**
 * Created by tom on 2016/5/15.
 */
@Controller
public class MessageController {

    //注意produces="text/event-stream"
    //charset=UTF-8 否则中文显示为乱码
    @RequestMapping(value = "/push", produces = "text/event-stream;charset=UTF-8")
    public
    @ResponseBody
    String push() {
        Random r = new Random();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:推送新闻，id为" + r.nextInt() + "\n\n";
    }
}
