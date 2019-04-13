package com.wangzhao.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *  @Component:创建对象，默认创建的是单例对象
 *      属性：value ,表示对象的id
 *      位置：在类的上面，表示创建该类的对象
 */

@Component("myStudent")
public class Student {
    @Value("张三")
    private String name;
    @Value("22")
    private int age;
    /**
     *  引用类型：使用框架的自动注入
     *
     * @Resource:来自jdk中的注解，给引用类型赋值，支持byName,byType。默认byName
     *      位置：1）在属性定义的上面，推荐使用，无需set方法
     *            2）在set方法的上面
     */
    //只按byName，需要指定@Resource的name属性，name来指定bean对象的名称
    @Resource(name="myXuexiao")
    private School mySchool;



    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", mySchool=" + mySchool +
                '}';
    }
}
