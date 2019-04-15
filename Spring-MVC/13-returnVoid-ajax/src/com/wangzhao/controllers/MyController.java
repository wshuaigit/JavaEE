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
     *  处理器方法返回void
     *     void：不表示数据，也不表示视图。用来响应ajax
     *           通过使用HttpServletResponse对象的输出流，将数据输出给浏览器
     */
    @RequestMapping(value = "myajax.do")
    public void doAjax(String name,Integer age,HttpServletResponse response) throws IOException {
        System.out.println("name："+name);
        System.out.println("age："+age);
        //调用Service处理请求，将处理结果输出给浏览器
        Student student = new Student();
        student.setName(name);
        student.setAge(age);

        //将Student转为Json,使用gson.jar
        Gson gson = new Gson();
        String json = gson.toJson(student);
        System.out.println("json："+json);

        //输出json到浏览器
        response.getWriter().write(json);
    }
}
