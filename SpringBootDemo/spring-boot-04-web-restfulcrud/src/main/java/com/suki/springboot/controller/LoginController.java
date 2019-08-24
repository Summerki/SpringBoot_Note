package com.suki.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

//    @RequestMapping(value = {"/user/login"}, method = RequestMethod.POST)
    @PostMapping("/user/login")  // 简化写法
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map,
                        HttpSession session){  // 注意，这里model，map，modelMap都会放到request域之中

        if (!StringUtils.isEmpty(username) && "123456".equals(password)) {
            // 登陆成功，防止表单重复提交，可以重定向到主页
            session.setAttribute("loginUser", username);  // 新增 存储进session的属性
            return "redirect:/main.html";
        } else {
            // 登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }

    }
}
