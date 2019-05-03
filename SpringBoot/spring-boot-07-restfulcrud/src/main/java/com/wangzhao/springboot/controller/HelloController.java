package com.wangzhao.springboot.controller;

import com.wangzhao.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Controller
public class HelloController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) throws UserNotExistException {
        if("aaa".equals(user)){
            throw new UserNotExistException("用户不存在");
        }
        return "Hello Wrold";
    }

    //查询一些数据在页面展示
    @RequestMapping("/success")
    public String success(HashMap<String,Object> map){
        map.put("hello","<h1>thymeleaf</h1>");
        map.put("users", Arrays.asList("zhangsan","lisi","wangwu"));

        //classpath:templates/success.html
        return "success";
    }
}
