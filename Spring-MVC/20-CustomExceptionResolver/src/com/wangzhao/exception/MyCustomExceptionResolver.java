package com.wangzhao.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName:MyCustomExceptionResolver
 * Package:com.wangzhao.exception
 * Description:
 *
 * @Date:2019/3/23 19:37
 * @Author:wangzhao
 */

/**
 *  自定义的异常处理器类
 */
public class MyCustomExceptionResolver implements HandlerExceptionResolver {
    /**
     *  resolverException()：当程序中抛出异常时，中央调度器会执行此方法，处理异常。
     *  参数：
     *      Object o：表示发生异常的处理器对象
     *      Exception e：异常对象
     *
     *  返回值：ModelAndView
     *      ModekAndView：表示异常的数据和视图页面
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                                         Object o, Exception e) {
        //调用Service把异常记录到数据库，记录到日志文件，发送邮件
        ModelAndView mv = new ModelAndView();
        mv.addObject("ex",e);
        //判断异常的类型
        if(e instanceof NameException){
            mv.addObject("tips","姓名不正确，必须时zs!!!");
            mv.setViewName("nameError");
        }else if(e instanceof AgeException){
            mv.addObject("tips","年龄不能大于50!!!");
            mv.setViewName("ageError");
        }else{
            //处理默认异常
            mv.addObject("tips","其他异常");
            mv.setViewName("defaultError");
        }
        return mv;
    }
}
