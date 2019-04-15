package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/16 21:08
 * @Author:wangzhao
 */

import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
     *  使用逐个接收，接收请求中的参数，请求中的参数名和处理器方法的形参名不一样
     *  需要在处理器方法的形参前面加入@RequestParam(vale="请求中的参数名")
     *
     *  @RequestMapping属性required，是boolean类型的，默认是true
     *  false 参数可以没有
     *
     */
    @RequestMapping(value = "login")
    public ModelAndView login(@RequestParam(value = "rname" ,required = false) String name,
                              @RequestParam(value = "rage" ,required = false) Integer age){
        //处理login的请求，login()就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        System.out.println("name："+name);
        System.out.println("age："+age);
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //指定视图
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "some.do")
    public ModelAndView doSome(){
        //处理login的请求，login()就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("fun","doSome()");
        //指定视图
        mv.setViewName("show");

        return mv;
    }
}
