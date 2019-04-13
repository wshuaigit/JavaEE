package com.wangzhao.ba05;

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
        String configLocation = "com/wangzhao/ba05/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        //从Spring中获取目标对象（修改后的代理对象）
        SomeService proxy = (SomeService) ac.getBean("someServiceTarget");
        //目标对象由接口，框架默认使用JDK动态代理
        //System.out.println("proxy："+proxy.getClass().getName());
        //通过代理执行目标方法
        //proxy.doSome();

        proxy.doThird();

    }
}
