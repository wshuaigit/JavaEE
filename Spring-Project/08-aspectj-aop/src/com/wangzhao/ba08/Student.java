package com.wangzhao.ba08;

/**
 * ClassName:Student
 * Package:com.wangzhao.ba02
 * Description:
 *
 * @Date:2019/3/10 13:21
 * @Author:wangzhao
 */
public class Student {
    private int age;
    private String name;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
