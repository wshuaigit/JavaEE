package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:PACKAGE_NAME
 * Description:
 *
 * @Date:2019/3/11 22:25
 * @Author:wangzhao
 */

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  实现Controller接口的类叫做处理器类
 *  处理器类能够处理用户的请求，是自定义的类
 *  处理器类也叫做后端控制器（back controller）
 */
public class MyController implements Controller {

    /**
     *  handleRequest()处理用户的请求，在方法中可以调用Service处理业务逻辑
     *  返回值：    ModelAndView
     *              Model：表示数据的，是一个Map的结构（MVC的Model）
     *              View：负责显示数据的，（MVC中的View）
     */
    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView mv = new ModelAndView();
        //调用Service层处理请求，把处理结果显示给用户

        //把处理结构的数据存放到Model
        //框架对数据的处理是：把数据放入到request作用域；等同于request.setAttribute("msg","hello SpringMVC")
        mv.addObject("msg","hello SpringMVC");

        //指定视图，在视图中显示Model中的数据
        //对视图的处理是执行forward()
        //等同于request.getRequestDispatcher("/show.jsp").forward(request,response)
        //mv.setViewName("/WEB-INF/jsp/show.jsp");

        //使用逻辑视图名称（文件名），配合视图解析器前缀 + 视图文件名 + 后置 = 完成的视图路径
        // /WEB-INF/jsp/   + show  + .jsp = /WEB-INF/jsp/show.jsp
        mv.setViewName("show");
        return mv;

    }
}
