package com.wangzhao.ba05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

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
     *  @Autowired:Spring框架提供的注解，给引用类型赋值
     *          位置：1）在属性定义的上面，无需set方法，推荐使用
     *                2）在set方法上面
     *
     *  @Autowired支持自动注入的byName,byType,默认时byType
     *
     *  使用byName
     *      1)@Autowired
     *      2)@Qualifer(value="bean的id")
     */
    //byName
    @Autowired(required = false)
    @Qualifier("myXueXiao111")
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
