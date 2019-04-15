package com.wangzhao.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 *  作为全局的异常处理器类
 */
@ControllerAdvice
public class AppExceptionResolver {
    /**
     *  在处理器中定义方法，在方法的上面加入@ExceptionHandler
     */
    //定义方法处理NameException
    @ExceptionHandler(value = { NameException.class })
    public ModelAndView doNameException(Exception ex){
        //调用Service的方法，进一步处理异常，记录到数据库，写入到文件
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","使用注解处理NameException");
        mv.addObject("ex",ex);
        mv.setViewName("nameError");
        return mv;
    }

    //定义方法处理NameException
    @ExceptionHandler(value =  AgeException.class )
    public ModelAndView doAgeException(Exception ex){
        //调用Service的方法，进一步处理异常，记录到数据库，写入到文件
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","使用注解处理AgeException");
        mv.addObject("ex",ex);
        mv.setViewName("ageError");
        return mv;
    }

    //定义方法，处理其他异常（NameException,AgeException之外的异常）
    @ExceptionHandler
    public ModelAndView doOtherException(Exception ex){
        //调用Service的方法，进一步处理异常，记录到数据库，写入到文件
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips","使用注解处理其他异常");
        mv.addObject("ex",ex);
        mv.setViewName("defaultError");
        return mv;
    }
}
