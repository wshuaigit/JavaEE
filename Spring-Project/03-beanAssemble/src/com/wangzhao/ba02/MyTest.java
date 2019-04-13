package com.wangzhao.ba02;


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
     *  单例作用域：存在范围是和容器对象一样
     *      单例作用域的对象创建时间？
     *          在创建容器对象时，会创建好所有的单例对象。
     *          创建好的对象放入到Spring的Map中
     *
     *      优点：获取对象的速度快
     *      缺点：占内存
     *
     */
    @Test
    public void test01(){
        String configLocation = "com/wangzhao/ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
    }

    /**
     *  原型作用域的对象在什么时候创建？
     *          在执行getBean()方法的时候才创建对象，原型作用域是把对象的创建
     *          时间延迟了，延迟到使用对象的时候
     *
     *          优点：不占内存
     *          缺点：获取对象的速度慢
     */
    @Test
    public void test02(){
        String configLocation = "com/wangzhao/ba02/applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

    }



}
