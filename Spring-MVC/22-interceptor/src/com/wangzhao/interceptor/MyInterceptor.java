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
    private long start ;
    private long end;
    /**
     *  preHandle()：预处理方法，用户的请求首先到达此方法，在方法中可以对请求做判断处理
     *
     *  参数：
     *      Object o：处理器对象
     *
     *  返回值：
     *      true:请求是能被处理的，拦截器的所有方法都会执行，afterCompletion()也能被执行
     *
     *            MyInterceptor拦截器执行了preHandle()
     *            执行了MyController的login方法
     *            MyInterceptor拦截器执行了postHandle()
     *            MyInterceptor拦截器执行了afterCompletion()
     *
     *      false: 请求不会被处理，到拦截器就截止了
     *            MyInterceptor拦截器执行了preHandle()
     *
     *  preHandle()可以看作是整个应用的总开关
     */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                             Object o) throws Exception {
        start = System.currentTimeMillis();
        System.out.println("MyInterceptor拦截器执行了preHandle()");
        return true;
    }

    /**
     *     postHandle()：后处理方法，在处理器方法执行后执行的。特点能够获取到处理器方法的返回值。
     *                   可以对返回值做处理，修改数据，修改视图。做二次处理
     *     参数：
     *       Object o：处理器对象
     *       ModelAndView modelAndView：处理器方法的返回值
     *
     */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor拦截器执行了postHandle()");
        //就该原来的执行结果，增加数据
        if(modelAndView != null){
            //增加数据
            modelAndView.addObject("msg","postHandle");

            //修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     *     afterCompletion()：最后执行的方法，在方法中可以做资源的回收，内存释放。
     *                        只有当拦截器的preHandle()方法返回true,才能执行
     *      参数：
     *     Object o：处理器对象
     *     ModelAndView modelAndView：处理器方法的返回值
     *
     *     请求处理完成：在视图处理完成后，认为请求处理完成
     *                   afterCompletion()方法是指视图处理完成后执行的
     */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
        end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println("MyInterceptor拦截器执行了afterCompletion()");
    }
}
