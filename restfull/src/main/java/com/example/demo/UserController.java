package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by tom on 2018/1/12.
 */
@Controller
@RequestMapping(value = "/users")     // 通过这里配置使下面的映射都在 /users
public class UserController {

    //@Autowired
   // UserService userService;          // 用户服务层

    /**
     *  获取用户列表
     *    处理 "/users" 的GET请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getUserList(ModelMap map) {
      //  map.addAttribute("userList", userService.findAll());
        return "userList";
    }
}