package com.wangzhao.ba03;

/**
 * ClassName:MyAspect
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:42
 * @Author:wangzhao
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 *  @Aspect：来自aspectJ框架，表示当前类是切面类
 *  切面类是用来给业务方法增强功能的类。
 *
 *  位置：在类的上面
 */
@Aspect
public class MyAspect {
    /**
     *  @Around: 环绕通知,在目标方法的前和后都能增强方法
     *      属性：value，表示切入点表达式
     *     位置：在方法的上面
     *
     *     特点：
     *          1、在目标方法的前和后都能增强功能
     *          2、能修改目标方法的执行结果
     *         3、能控制目标方法是否执行
     *
     *    参数：
     *         ProceedingJoinPoint:继承org.aspectj.lang.JoinPoint ,表示切入点
     *
     *    返回值：
     *         Object:表示目标方法的执行结果
     */
     @Around("execution(* *..SomeServiceImpl.doFirst(..))")
     public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
         //myAround就相当于jdk中InvocationHandler中的invoke()

         //获取切入点的定义
         System.out.println("切入点的方法签名："+pjp.getSignature());

         Object result= null;
         //在目标方法之前，增强功能
         System.out.println("环绕通知：在目标方法之前，加入日志功能");
         //执行目标方法
         result = pjp.proceed();    //method.invoke()
         //修改目标方法的执行结果
         if(result != null){
             String str = (String)result;
             result = "hello AspectJ "+ str.toUpperCase();
         }
         //在目标方法之后，加入事务
         System.out.println("环绕通知：在目标方法之后，加入事务功能");

        //返回目标方法的执行结果
         return result;
     }
}
