package com.wangzhao.test;

import com.wangzhao.service.SomeService;
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
    public static void main(String[] args) {
        //要使用Spring管理的对象

        //1.定义变量，保存Spring配置文件的路径和名称
        String configLocation = "applicationContext.xml"; //类路径的根目录

        //2.创建Spring容器对象，ApplicationContext接口
        //根据配置文件的位置，使用不同的实现类
        //如果配置文件放在类路径中（classpath），需要使用ClassPathXmlApplicationContext实现类
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

        //3.从容器中获取对象，使用getBean("<bean>的id属性值")
        SomeService someService = (SomeService) ac.getBean("someService");

        //4.调用对象的方法
        someService.doSome();
    }

    /**
     *  Spring的配置文件放在磁盘目录中
     *  需要使用 FileSystemXmlApplicationContext 实现读取磁盘中的配置文件
     */
    @Test
    public void test01(){
        //读取磁盘文件
        String configLocation = "D:\\data\\applicationContext.xml";
        ApplicationContext ac = new FileSystemXmlApplicationContext(configLocation);
        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome();
    }

    /**
     *  Spring的配置文件放在项目根目录下，和src、lib是同级的
     *  需要使用 FileSystemXmlApplicationContext 实现读取配置文件
     */
    @Test
    public void test02(){
        //配置文件放在项目的根目录下，只需提供文件名称就行
        String configLocation = "applicationContext.xml";
        ApplicationContext ac = new FileSystemXmlApplicationContext(configLocation);
        SomeService someService = (SomeService) ac.getBean("someService");
        someService.doSome();
    }

    /**
     *  在创建Spring容器对象的时候，会创建Spring配置文件中的所有对象
     */
    @Test
    public void test03(){
        String configLocation = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

    }

    /**
     *  获取容器中对象的信息
     */
    @Test
    public void test04(){
        String configLocation = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);

        //获取容器中定义的对象的个数
        int count = ac.getBeanDefinitionCount();
        System.out.println("容器中定义的对象的个数："+count);

        //获取容器中定义的每个对象的名称
        String[] names = ac.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }
    }
}
