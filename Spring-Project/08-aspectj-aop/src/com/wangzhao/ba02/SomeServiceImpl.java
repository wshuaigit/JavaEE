package com.wangzhao.ba02;

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
}
