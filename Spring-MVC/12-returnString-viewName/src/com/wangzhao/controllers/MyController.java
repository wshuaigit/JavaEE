package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/16 21:08
 * @Author:wangzhao
 */

import com.wangzhao.pojo.Student;
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
     *  使用处理器方法的返回值表示处理结果
     *
     *  返回String，String表示视图
     *  1、逻辑视图
     *  2、完整路径
     */
    @RequestMapping(value = "login")
    public String login(Student student){
        System.out.println("login参数name："+student.getName()+"  age："+student.getAge());
        //处理login的请求，login就相当于Servlet的doGet()

        //调用Service处理请求。结果通过返回值输出给浏览器

        //指定逻辑名称：对视图执行forward
       // return "show";

        //使用视图的完整路径，不能使用视图解析器
        return "/WEB-INF/jsp/show.jsp";
    }

}
