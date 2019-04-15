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
     *  使用对象接受请求中的参数，要求参数名和对象的属性名一样
     */
    @RequestMapping(value = "login")
    public ModelAndView login(Student student){

        //处理login的请求，login()就相当于Servlet的doGet
        ModelAndView mv = new ModelAndView();
        System.out.println("name："+student.getName());
        System.out.println("age："+student.getAge());
        //调用Service处理业务，将处理结果显示到视图
        mv.addObject("myName",student.getName());
        mv.addObject("myAge",student.getAge());
        mv.addObject("myStudent",student);
        //指定视图
        mv.setViewName("show");
        return mv;
    }

}
