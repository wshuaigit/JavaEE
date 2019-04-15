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
@RequestMapping(value = "test")
public class MyController {

    /**
     *  @RequestMapping：请求映射，把请求指定给某个方法处理
     *  使用@RequestMapping修饰的方法叫做处理器方法，处理器方法是处理用户请求的
     *          属性：1）value ，表示请求的URI(地址，资源)。URI的值必须是唯一的
     *                   可以“/”开头，也可以不加“/”
     *                2）method ， 它的值是RequestMethod[]，表示请求的方式，
     *                   使用RequestMethod类的枚举值，表示请求方式
     *                3）params，params的值表示字符串数组
     */
     //指定some.do的请求中必须有name,age两个参数，可以有更多的参数
    @RequestMapping(value = "some.do",params = {"name","age"})
    public ModelAndView doSome(){
        //处理some.do的请求，doSome就相当于Servelt的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","Hello SpringMVC");
        //指定视图
        mv.setViewName("show");
        return mv;
    }
    //指定other.do的请求中必须有age参数，不能有name参数，可以有更多的参数
    @RequestMapping(value = "other.do",params = {"!name","age"})
    public ModelAndView doOther(){
        //处理some.do的请求，doSome就相当于Servelt的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("msg","doOther");
        //指定视图
        mv.setViewName("show");
        return mv;
    }

    //first.do必须有name，name的值必须是zs,请求中必须有age，气质必须是23，可以有其他值
    @RequestMapping(value = "first.do",params = {"name=zs","age=23"})
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        String name = request.getParameter("name");
        System.out.println(name);
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println(age);
        return null;
    }

}
