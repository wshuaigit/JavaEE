package com.wangzhao.ba01;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/6 22:47
 * @Author:wangzhao
 */
public class MyTest {
    @Test
    public void test01(){
        String configLocation = "com/wangzhao/ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        Student student = (Student) ac.getBean("student");
        System.out.println(student);
    }
}
