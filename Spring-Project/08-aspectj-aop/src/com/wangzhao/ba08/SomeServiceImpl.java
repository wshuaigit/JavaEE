package com.wangzhao.ba08;

/**
 * ClassName:SomeServiceImpl
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:41
 * @Author:wangzhao
 */
public class SomeServiceImpl implements SomeService {
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }

    @Override
    public String doOther(int i)  {
        System.out.println("执行业务方法doOther(): "+i);
        return "abcd";
    }

    @Override
    public Student doOther2(int i) {
        System.out.println("执行业务方法doOther2(): "+i);
        Student stu = new Student();
        stu.setAge(20);
        stu.setName("李四");
        return stu;
    }

    @Override
    public String doFirst() {
        System.out.println("执行了业务方法doFirst()");
        return "doFirst";
    }

    @Override
    public void doSecond(){
        int i = 1/0;
        System.out.println("执行了业务方法doSecond()");
    }

    @Override
    public void doThird() {
        int i = 1/0;
        System.out.println("执行了业务方法doThird()");
    }
}
