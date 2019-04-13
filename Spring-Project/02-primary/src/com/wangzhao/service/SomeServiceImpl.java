package com.wangzhao.service;

/**
 * ClassName:SomeServiceImpl
 * Package:com.wangzhao.service
 * Description:
 *
 * @Date:2019/3/5 23:36
 * @Author:wangzhao
 */

public class SomeServiceImpl implements SomeService{

    public SomeServiceImpl(){
        System.out.println("执行无参构造方法");
    }

    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }
}
