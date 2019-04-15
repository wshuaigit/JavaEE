package com.wangzhao.controllers;

/**
 * ClassName:MyController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/16 21:08
 * @Author:wangzhao
 */

import com.google.gson.Gson;
import com.wangzhao.pojo.Student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
     *  处理器方法返回Object-Student
     *
     *  @ResponseBody：将数据输出到浏览器（输出到应答体中）
     *          位置：在处理器方法的上面
     *
     *  框架的处理逻辑
     *      1、框架根据处理器方法的返回值的数据类型，HttpMessageConverter接口的实现类对象。
     *          Student  -  MappingJackson2HttpMessageConverter
     *      2、框架调用HttpMessageConverter接口的实现类对象，处理返回值，把Student转为
     *         text/json;charset=utf-8
     *      3、把2步骤中的结果数据，通过使用HttpServletResponse的输出流对象，输出到浏览器
     *          有@ResponseBody注解完成的。
     *
     */
    @RequestMapping(value = "myajax.do")
    @ResponseBody
    public Student doAjax(String name,Integer age) throws IOException {
        System.out.println("name："+name);
        System.out.println("age："+age);

        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        return student;
    }

}
