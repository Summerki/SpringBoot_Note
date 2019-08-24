package com.suki.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    // 处理请求
    @ResponseBody
    @RequestMapping("hello")
    public String hello(){
        return "hello world!";
    }

}
