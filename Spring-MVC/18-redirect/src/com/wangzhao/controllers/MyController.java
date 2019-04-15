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
import org.springframework.web.servlet.ModelAndView;
import sun.misc.Unsafe;

import java.lang.instrument.Instrumentation;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/**
 * @Controller:创建处理器对象，默认是单例对象
 *             位置：在类的上面
 *
 * @RequestMapping：请求映射
 *             value:在类的上面使用，value表示请求地址的公共部分，我们叫做模块名称
 */
@Controller
public class MyController {

    /**
     *  处理器方法返回ModelAndView
     *  语法格式：setViewName("redirect:视图的完整路径")
     *
     *  redirect：使用特点是不和视图解析器一同工作，就当项目中没有视图解析器
     *  优势：当项目中大多数的视图使用视图解析器，有某些视图不在视图的目录中，可以使用redirect指定其他位置
     *
     *  重定向：
     *      1、重定向使用redirect，不能访问收保护的/WEB-INF下面的资源
     *      2、放入到ModleAndView中的简单类型的值，能够被框架转为String
     *         作为重定向的get请求的参数传递。放入到ModelAndView中的对象
     *      3、在重定向的目标页面中，要获取get请求的参数，使用${param.参数名}
     */
    @RequestMapping(value = "some.do")
    public ModelAndView doSome(Integer age,String name){
        System.out.println("doSome的参数 name："+name+" || age："+age);
        //处理some.do的请求，doSome就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //指定redirect的视图
        //setViewName("redirect:视图的完整路径")
        //重定向不可以访问WEB-INF目录下的资源
        //mv.setViewName("redirect:/WEB-INF/jsp/show.jsp");

        mv.setViewName("redirect:/show.jsp");
        //http://localhost:8080/18-redirect/show.jsp?myName=lisi&myAge=123

        return mv;
    }

    /**
     *  处理器方法返回值是String，使用redirect重定向到视图
     */
    @RequestMapping("other.do")
    public String doOther(){
        //转发到视图页面，语法forward：视图的完整路径
        return "redirect:/show.jsp";
    }

    /**
     *   重定向到其他的处理器，由其他处理器方法继续处理请求
     *   语法：redirect:xxx.do
     */
    @RequestMapping("dispather.do")
    public ModelAndView doDispather(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        //request.setAttribute()
        mv.addObject("myName",name);
        mv.addObject("myAge",age);

        //转发到其他的处理器
        mv.setViewName("redirect:process.do");
        //http://localhost:8080/18-redirect/process.do?myName=lisi&myAge=123
        return mv;
    }

    //处理器方法，处理重定向过来的请求
    @RequestMapping("process.do")
    public String doProcess(String myName,Integer myAge){
        System.out.println("===============doProcess=================");
        System.out.println("myName："+myName);
        System.out.println("myAge："+myAge);
        //视图的逻辑名称，forward到
        return "show.jsp";
    }



}

