package com.wangzhao.ba07;

/**
 * ClassName:SomeServiceImpl
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:41
 * @Author:wangzhao
 */
public class SomeServiceImpl {

    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }


    public String doOther(int i)  {
        System.out.println("执行业务方法doOther(): "+i);
        return "abcd";
    }


    public Student doOther2(int i) {
        System.out.println("执行业务方法doOther2(): "+i);
        Student stu = new Student();
        stu.setAge(20);
        stu.setName("李四");
        return stu;
    }


    public String doFirst() {
        System.out.println("执行了业务方法doFirst()");
        return "doFirst";
    }

    public void doSecond(){

        System.out.println("执行了业务方法doSecond()");
    }


    public void doThird() {
        System.out.println("执行了业务方法doThird()");
    }
}
