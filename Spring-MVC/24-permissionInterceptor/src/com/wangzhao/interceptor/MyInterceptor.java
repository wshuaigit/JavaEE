package com.wangzhao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MyInterceptor
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/24 22:45
 * @Author:wangzhao
 */
//拦截器
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        System.out.println("MyInterceptor111拦截器执行了preHandle()");

        //实现身份的认证
        String username = "";
        //从Session中获取用户的信息
        Object attr = httpServletRequest.getSession().getAttribute("username");
        if(attr != null){
            username = (String)attr;
        }

        //判断登录的用户是否是张三
        if(!"zhangsan".equals(username)){
            httpServletRequest.getRequestDispatcher("fail.jsp").forward(httpServletRequest,httpServletResponse);
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor111拦截器执行了postHandle()");
    }


    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        System.out.println("MyInterceptor111拦截器执行了afterCompletion()");
    }
}
