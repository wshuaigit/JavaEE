package com.wangzhao.ba07;

/**
 * ClassName:MyAspect
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:42
 * @Author:wangzhao
 */

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 *  @Aspect：来自aspectJ框架，表示当前类是切面类
 *  切面类是用来给业务方法增强功能的类。
 *
 *  位置：在类的上面
 */
@Aspect
public class MyAspect {
    /**
     *       @After: 最终通知
     *        属性：value,表示切入点表达式
     *        位置：在方法的上面
     *
     *        特点：
     *          1. 在目标方法之后执行的
     *          2. 总是会被执行的
     *
     *        try{
     *
     *        }finally{
     *             //最终通知的代码
     *        }
     */
    @After("mypt()")
    public void myAfter(){
        //程序执行完毕后最后要执行的工作，例如释放数据库的连接池，释放内存
        System.out.println("最终通知：总是会被执行的内容");
    }

    /**
     *      @Pointcut: 管理和定义切入点的，不是通知注解。如果切面有多个通知使用相同的切入点表达式。
     *                 可以使用@Pointcut集中定义切入点
     *
     *                 属性：value,切入点表达式
     *                位置：在自定义的方法上面
     *
     *                特点：
     *                  1.集中定义和管理切入点
     *                  2.使用@Pointcut定义的方法名，就是切入点的别名
     *
     *                其他通知注解中的value属性可以使用方法名，表示切入点
     */
    @Pointcut("execution(* *..SomeServiceImpl.doThird(..))")
    public void mypt(){
        //不需要代码
    }

}
