package com.wangzhao.test;

import com.wangzhao.pojo.Student;
import com.wangzhao.service.StudentService;
import javafx.application.Application;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.test
 * Description:
 *
 * @Date:2019/3/10 21:15
 * @Author:wangzhao
 */
public class MyTest {

    private StudentService service = null;
    @Before
    public void myinit(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        service = (StudentService) ac.getBean("studentService");
    }


    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ac.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }

    //测试添加功能
    @Test
    public void test02(){
        Student student = new Student();
        student.setAge(20);
        student.setName("李四");
        int row = service.addStudent(student);
        System.out.println(row);
    }

    //测试查询功能
    @Test
    public void test03(){
        List<Student> list = service.queryStudent();
        System.out.println(list);
    }
}
