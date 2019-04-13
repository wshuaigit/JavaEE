package com.wangzhao.di07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.di01
 * Description:
 *
 * @Date:2019/3/6 17:44
 * @Author:wangzhao
 */
public class MyTest {

    @Test
    public void test01(){
        String configLocation1 = "com/wangzhao/di07/spring-student.xml";    //类路径的根目录
        String configLocation2 = "com/wangzhao/di07/spring-school.xml";     //类路径的根目录
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation1,configLocation2);
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student.toString());
    }
}
