package com.wangzhao.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * ClassName:MyInterceptor
 * Package:com.wangzhao.proxy
 * Description:
 *
 * @Date:2019/3/7 21:53
 * @Author:wangzhao
 */
//方法拦截器类，实现功能的增强
public class MyInterceptor implements MethodInterceptor {

    private Object target;

    public MyInterceptor(Object target) {
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     *  intercept()等同于jdk中invoke()
     *      作用：拦截用户的请求，调用业务方法的时候，首先执行intercept
     *
     *      参数：
     *          o : 系统生成的代理对象
     *          method : 正则执行的业务方法（目标方法）
     *          objects : 目标方法的参数列表
     *          methodProxy : 目标方法的代理对象
     *
     *     返回：
     *          Object : 目标方法的执行结果（可以是修改后的结果）
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("=====intercept=====");
        //调用目标方法
        Object result = method.invoke(target, objects); //doSome

        //返回目标方法的执行结果
        return result;
    }
}
