package com.wangzhao.ba07;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:36
 * @Author:wangzhao
 */
public class MyTest {

    @Test
    public void test01(){
        String configLocation = "com/wangzhao/ba07/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        //从Spring中获取目标对象（修改后的代理对象）
        SomeServiceImpl proxy = (SomeServiceImpl) ac.getBean("someServiceTarget");
        //目标对象没有接口，框架使用CGLIB动态代理
        System.out.println("proxy："+proxy.getClass().getName());

        proxy.doThird();

    }
}
