package com.wangzhao.test;

import com.wangzhao.proxy.ProxyFactory;
import com.wangzhao.service.SomeServiceImpl;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.test
 * Description:
 *
 * @Date:2019/3/7 22:23
 * @Author:wangzhao
 */
public class MyTest {
    public static void main(String[] args) {
        //创建目标对象
        SomeServiceImpl target = new SomeServiceImpl();
        //创建工具类对象
        ProxyFactory factory = new ProxyFactory();
        //调用工具方法
        SomeServiceImpl proxy = (SomeServiceImpl) factory.createProxy(target);
        //通过代理对象执行业务方法
        proxy.doSome();
    }
}
