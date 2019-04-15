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
        return false;
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
