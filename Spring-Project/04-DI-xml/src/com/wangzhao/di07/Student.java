package com.wangzhao.di07;

/**
 * ClassName:Student
 * Package:com.wangzhao.di01
 * Description:
 *
 * @Date:2019/3/6 17:48
 * @Author:wangzhao
 */
public class Student {

    public Student(String name, int age, School school){
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public Student(){

    }
    private String name;
    private int age;
    private School school;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
