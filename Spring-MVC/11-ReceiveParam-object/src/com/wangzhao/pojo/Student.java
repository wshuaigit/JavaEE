package com.wangzhao.pojo;

/**
 * ClassName:Student
 * Package:com.wangzhao.pojo
 * Description:
 *
 * @Date:2019/3/19 21:57
 * @Author:wangzhao
 */
public class Student {

    //参数名和属性名一样
    private String name;
    private int age;

    public Student() {
        System.out.println("Studnet类的无参数构造方法");
    }

    public void setName(String name) {
        System.out.println("setName："+name);
        this.name = name;
    }


    public void setAge(int age){
        System.out.println("setAge："+age);
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
