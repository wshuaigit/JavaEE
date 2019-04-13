package com.wangzhao.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *  @Component:创建对象，默认创建的是单例对象
 *      属性：value ,表示对象的id
 *      位置：在类的上面，表示创建该类的对象
 */

@Component("myStudent")
public class Student {
    /**
     * 简单类型的属性赋值：@Value
     *               属性：value,指定简单类型的属性值
     *               位置：1）在属性定义的上面，无需set方法，推荐使用
     *                     2）在set方法的上面
     */
    @Value("张三")
    private String name;

    private int age;

    @Value("22")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
