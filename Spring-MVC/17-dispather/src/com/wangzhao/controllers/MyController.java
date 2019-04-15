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

import java.util.ArrayList;
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
     *  语法格式：setViewName("forward:视图的完整路径")
     *
     *  forward：使用特点是不和视图解析器一同工作，就当项目中没有视图解析器
     *  优势：当项目中大多数的视图使用视图解析器，有某些视图不在视图的目录中，可以使用forward指定其他位置
     */
    @RequestMapping(value = "some.do")
    public ModelAndView doSome(Integer age,String name){
        System.out.println("doSome的参数 name："+name+" || age："+age);
        //处理some.do的请求，doSome就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
        //指定forward的视图
        //setViewName("forward:视图的完整路径")
        mv.setViewName("forward:WEB-INF/jsp/show.jsp");

        return mv;
    }

    /**
     *  处理器方法返回值是String，使用forward转发到视图
     */
    @RequestMapping("other.do")
    public String doOther(){
        //转发到视图页面，语法forward：视图的完整路径
        return "forward:WEB-INF/jsp/show.jsp";
    }

    /**
     *   转发到其他的处理器，由其他处理器方法继续处理请求
     *   语法：forward:xxx.do
     */
    @RequestMapping("dispather.do")
    public ModelAndView doDispather(String name,Integer age){
        ModelAndView mv = new ModelAndView();
        //request.setAttribute()
        mv.addObject("myName",name);
        mv.addObject("myAge",age);

        //转发到其他的处理器
        mv.setViewName("forward:process.do");
        return mv;
    }

    //处理器方法，处理转发过来的请求
    @RequestMapping("process.do")
    public String doProcess(){
        System.out.println("===========doProcess=================");
        //视图的逻辑名称，forward到
        return "show";
    }

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        for (String temp : a) {
            if("2".equals(temp)){
                a.remove(temp);
            }
        }




    }

}
