package com.wangzhao.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.wangzhao.beans.Student;
import com.wangzhao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName:StudentController
 * Package:com.wangzhao.controllers
 * Description:
 *
 * @Date:2019/3/26 19:42
 * @Author:wangzhao
 */
@Controller
public class StudentController {

    /**
     *  引用类型 @Autowired,@Resource
     *  byName,byType
     */
    //byType
    @Autowired
    private StudentService studentService;

    //学生的注册，添加功能
    @RequestMapping("addstudent")
    public ModelAndView addStudent(Student student){

        ModelAndView mv = new ModelAndView();


        //调用Service处理注册功能
        int rows = studentService.addStudent(student);
        if(rows > 0){
            mv.addObject("msg","注册成功");
            mv.setViewName("success");
        }else {
            mv.addObject("msg","注册失败");
            mv.setViewName("fail");
        }
        return mv;
    }

    //查询学生
    @ResponseBody
    @RequestMapping("queryStudent")
    public List<Student> queryStudent(){
        List<Student> list = studentService.queryStudents();
        System.out.println(list);
        //对查询结果做处理
        if(list == null){
            list = new ArrayList<>();
        }
        return list;
    }
}
