package com.wangzhao.ba03;

/**
 * ClassName:SomeServiceImpl
 * Package:com.wangzhao.service
 * Description:
 *
 * @Date:2019/3/5 23:36
 * @Author:wangzhao
 */

public class SomeServiceImpl implements SomeService {

    /**
     *  框架默认是使用无参构造方法创建对象
     */
    public SomeServiceImpl(){
        System.out.println("执行无参构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }

    /**
     * 自定义方法，参与到Spring创建对象的过程
     */
    //bean初始化之前的方法
    public void setUp(){
        System.out.println("bean的初始化方法，可以完成构造方法的功能，给属性赋值，初始化其他对象");
    }

    /**
     *  bean销毁之前执行的方法
     */
    public void tearDawn(){
        System.out.println("bean对象销毁之前执行的方法，清除对象，释放内存");
    }
}
