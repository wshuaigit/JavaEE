package com.wangzhao.ba03;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
     *  初始化方法的执行
     *      1）SomeService service = new SomeServiceImpl();
     *      2)service.setUp();
     *      3）单例对象调用销毁方法
     *          service.tearDown();
     */
    @Test
    public void test01(){
        ApplicationContext ac = new ClassPathXmlApplicationContext("com/wangzhao/ba03/applicationContext.xml");
        SomeService someService = (SomeService) ac.getBean("someService");

        someService.doSome();

        /**
         *  销毁方法的执行：
         *      1.关闭容器，软笔容器时会通知容器中的单例对象，调用对象自己的销毁方法
         *      2. Bean对象必须是单例的
         */
        ((ClassPathXmlApplicationContext)ac).close();
    }

}
