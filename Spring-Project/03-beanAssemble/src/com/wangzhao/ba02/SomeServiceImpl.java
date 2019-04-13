package com.wangzhao.ba02;

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
}
