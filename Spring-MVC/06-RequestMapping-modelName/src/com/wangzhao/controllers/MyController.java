package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/16 21:08
 * @Author:wangzhao
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller:创建处理器对象，默认是单例对象
 *             位置：在类的上面
 *
 * @RequestMapping：请求映射
 *             value:在类的上面使用，value表示请求地址的公共部分，我们叫做模块名称
 */
@Controller
@RequestMapping(value = "test")
public class MyController {

    //自定义方法处理请求
    @RequestMapping(value = {"some.do","first.do"})
    public ModelAndView doSome(){
        //处理some.do的请求，doSome就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","Hello SpringMVC Annotation");
        //指定视图
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "other.do" ,method = RequestMethod.POST)
    public ModelAndView doOther(){
        //处理some.do的请求，doSome就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","do Other");
        //指定视图
        mv.setViewName("show");
        return mv;
    }
}
