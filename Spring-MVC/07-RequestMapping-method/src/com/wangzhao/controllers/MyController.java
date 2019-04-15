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

    /**
     *  @RequestMapping：请求映射，把请求指定给某个方法处理
     *  使用@RequestMapping修饰的方法叫做处理器方法，处理器方法是处理用户请求的
     *          属性：1）value ，表示请求的URI(地址，资源)。URI的值必须是唯一的
     *                   可以“/”开头，也可以不加“/”
     *                2）method ， 它的值是RequestMethod[]，表示请求的方式，
     *                   使用RequestMethod类的枚举值，表示请求方式
     */
     //指定some.do只能使用get请求方式
    @RequestMapping(value = "some.do",method = RequestMethod.GET)
    public ModelAndView doSome(){
        //处理some.do的请求，doSome就相当于Servelt的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","Hello SpringMVC");
        //指定视图
        mv.setViewName("show");
        return mv;
    }

    @RequestMapping(value = "other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        //处理some.do的请求，doSome就相当于Servelt的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","doOther");
        //指定视图
        mv.setViewName("show");
        return mv;
    }

    //first.do 不指定method属性，表示请求方式没有限制
    @RequestMapping(value = "first.do")
    public ModelAndView doFirst(){
        //处理some.do的请求，doSome就相当于Servelt的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","doFirst");
        //指定视图
        mv.setViewName("show");
        return mv;
    }

}
