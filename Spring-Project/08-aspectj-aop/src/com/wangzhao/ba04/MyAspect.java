package com.wangzhao.ba04;

/**
 * ClassName:MyAspect
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:42
 * @Author:wangzhao
 */

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
     * @AfterThrowing : 异常通知，目标方法抛出异常时执行的。
     *              属性： 1. value,表示切入点表达式
     *                     2. throwing,自定义的表露，表示目标方法抛出的异常对象，需要和通知方法的参数名一样。
     *             位置：在方法的上面
     *             特点：
     *                  1.在目标方法抛出异常时执行的
     *                  2.不是异常处理程序，只是得到异常的消息
     *                  3.可以作为目标方法的监控程序，检查目标方法是否正常执行
     *
     */
    @AfterThrowing(value = "execution(* *..SomeServiceImpl.doSecond(..))",throwing = "ex")
    public void myAfterThrowing(Throwable ex){
        //对得到的异常信息，可以做处理。发送邮件，短信通知相关人员，处理问题
        //把得到的异常记录到数据库，日志文件，以后可以排查错误
        System.out.println("异常通知：在目标方法抛出异常时执行，异常是："+ex.getMessage());

    }
    /**
     *  try{
     *      doSecond();
     *  }catch(Exception ex){
     *      myAfterThrowing(ex)
     *  }
     */
}
