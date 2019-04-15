package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/16 21:08
 * @Author:wangzhao
 */

import com.wangzhao.exception.AgeException;
import com.wangzhao.exception.MyUserException;
import com.wangzhao.exception.NameException;
import org.omg.PortableServer.REQUEST_PROCESSING_POLICY_ID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
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
     *      抛出异常给中央调度器，由中央调度器处理异常
     */
    @RequestMapping(value = "login")
    public ModelAndView login(String name,Integer age) throws MyUserException {
        System.out.println("login的参数name："+name+" age："+age);
        //根据name,age的值抛出异常
        if(!"zs".equals(name)){
            throw new NameException("姓名不正确");
        }
        if(age == null || age.intValue() > 50){
            throw new AgeException("年龄太大了！！！");
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("myName",name);
        mv.addObject("myAge",age);
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
