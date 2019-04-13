package com.wangzhao.ba01;

/**
 * ClassName:MyAspect
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:42
 * @Author:wangzhao
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 *  @Aspect：来自aspectJ框架，表示当前类是切面类
 *  切面类是用来给业务方法增强功能的类。
 *
 *  位置：在类的上面
 */
@Aspect
public class MyAspect {

    //自定义方法实现切面的功能，例如打印日志

    /**
     * @Before:前置通知
     *      属性：value,表示切入点表达式（切面功能加入的位置）
     *      位置：在方法的上面
     *
     *      特点：
     *          1、在目标方法之前先执行的
     *          2、不能改变目标方法的执行结构
     *          3、不会影响目标方法的执行
     */
//    @Before("execution(* com.wangzhao.ba01.SomeServiceImpl.doSome())")
//    public void myBefore(){
//        //实现日志的打印功能。
//        System.out.println("前置通知，在目标方法之前，实现日志功能");
//    }

//    @Before("execution(* *..SomeServiceImpl.doSome())")
//    public void myBefore(){
//        //实现日志的打印功能。
//       System.out.println("前置通知，在目标方法之前，实现日志功能");
//    }

    /**
     *  通知方法可以带有参数
     *      JoinPoint:连接点，是一个方法
     */
    @Before("execution(* *..SomeServiceImpl.do*(..))")
    public void myBefore(JoinPoint jp){
        //获取方法得签名，即方法得定义
        System.out.println("连接点方法的签名："+jp.getSignature());
        //获取连接点方法的参数列表
        Object[] args = jp.getArgs();
        System.out.println("连接到方法的个数："+args.length);
        //实现日志的打印功能。
        System.out.println("前置通知，在目标方法之前，实现日志功能");
    }

}
