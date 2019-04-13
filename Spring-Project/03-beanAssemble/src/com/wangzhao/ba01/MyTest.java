package com.wangzhao.ba01;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.test
 * Description:
 *
 * @Date:2019/3/6 13:23
 * @Author:wangzhao
 */
public class MyTest {

    /**
     *  在创建Spring容器对象的时候，会创建Spring配置文件中的所有对象
     */
    @Test
    public void test01(){
        String configLocation = "com/wangzhao/ba01/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome();

    }


}
