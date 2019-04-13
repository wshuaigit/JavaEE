package com.wangzhao.ba05;

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
        String configLocation = "com/wangzhao/ba05/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        Student student = (Student) ac.getBean("myStudent");
        System.out.println(student);
    }
}
