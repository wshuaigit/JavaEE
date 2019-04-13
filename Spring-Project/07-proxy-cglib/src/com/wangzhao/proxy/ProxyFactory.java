package com.wangzhao.proxy;

import com.wangzhao.service.SomeServiceImpl;
import net.sf.cglib.proxy.Enhancer;

/**
 * ClassName:ProxyFactory
 * Package:com.wangzhao.proxy
 * Description:
 *
 * @Date:2019/3/7 22:01
 * @Author:wangzhao
 */
public class ProxyFactory {

    //定义工具方法，创建代理对象
    public Object createProxy(Object target){
        // 1.创建cglib中的Enhance对象
        Enhancer en = new Enhancer();
        // 2.指定目标类对象
        en.setSuperclass(SomeServiceImpl.class);
        // 3.指定方法拦截器对象
        en.setCallback(new MyInterceptor(target));
        // 4.创建代理对象
        return en.create();
    }
}
