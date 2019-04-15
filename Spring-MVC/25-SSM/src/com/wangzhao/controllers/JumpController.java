package com.wangzhao.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:JumpController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/26 19:54
 * @Author:wangzhao
 */
@Controller
@RequestMapping("jump")
public class JumpController {
    /**
     *  定义处理器方法，跳转到一个视图页面
     */
    @RequestMapping("tojsp.do")
    public String toJsp(String target){
        return target;//逻辑名称
    }
}
