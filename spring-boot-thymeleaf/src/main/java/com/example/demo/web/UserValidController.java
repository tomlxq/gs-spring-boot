package com.example.demo.web;


import com.example.demo.domain.ValidUser;
import com.example.demo.service.UserValidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 用户控制层
 *
 * Created by bysocket on 24/07/2017.
 */
@Controller
@RequestMapping(value = "/validUsers")     // 通过这里配置使下面的映射都在 /users
public class UserValidController {

    @Autowired
    UserValidService userValidService;          // 用户服务层

    /**
     *  获取用户列表
     *    处理 "/users" 的 GET 请求，用来获取用户列表
     *    通过 @RequestParam 传递参数，进一步实现条件查询或者分页查询
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getValidUserList(ModelMap map) {
        map.addAttribute("validUserList", userValidService.findAll());
        return "userValidList";
    }

    /**
     * 显示创建用户表单
     *
     */
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String createValidUserForm(ModelMap map) {
        map.addAttribute("validUser", new ValidUser());
        map.addAttribute("action", "create");
        return "userValidForm";
    }

    /**
     *  创建用户
     *    处理 "/users" 的 POST 请求，用来获取用户列表
     *    通过 @ModelAttribute 绑定参数，也通过 @RequestParam 从页面中传递参数
     */
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String postValidUser(ModelMap map,
                           @ModelAttribute @Valid ValidUser validUser,
                           BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "create");
            return "userValidForm";
        }

        userValidService.insertByValidUser(validUser);

        return "redirect:/validUsers/";
    }


    /**
     * 显示需要更新用户表单
     *    处理 "/users/{id}" 的 GET 请求，通过 URL 中的 id 值获取 User 信息
     *    URL 中的 id ，通过 @PathVariable 绑定参数
     */
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String getValidUser(@PathVariable Long id, ModelMap map) {
        map.addAttribute("validUser", userValidService.findById(id));
        map.addAttribute("action", "update");
        return "userValidForm";
    }

    /**
     * 处理 "/users/{id}" 的 PUT 请求，用来更新 User 信息
     *
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String putValidUser(ModelMap map,
                          @ModelAttribute @Valid ValidUser validUser,
                          BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            map.addAttribute("action", "update");
            return "userValidForm";
        }

        userValidService.update(validUser);
        return "redirect:/validUsers/";
    }
    /**
     * 处理 "/users/{id}" 的 GET 请求，用来删除 User 信息
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteValidUser(@PathVariable Long id) {

        userValidService.delete(id);
        return "redirect:/validUsers/";
    }

}