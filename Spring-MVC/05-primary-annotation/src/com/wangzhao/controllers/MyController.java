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

import javax.servlet.http.HttpServletRequest;

/**
 * @Controller:创建处理器对象，默认是单例对象
 *             位置：在类的上面
 */
@Controller
public class MyController {

    //自定义方法处理请求

    /**
     *   @RequestMapping：请求映射，把请求指定给某个方法处理
     *                    使用@RequestMapping修饰的方法叫做处理器方法，处理器方法是处理用户请求的
     *               属性：1）value，表示请求的uri(地址，资源)。uri的值必须是唯一的。
     *                        可以“/” 开头，也可以不加“/”
     *               位置：
     *                      1.在方法的上面，常用的
     *                      2.在类的上面
     */
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

    @RequestMapping(value = "other.do")
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
