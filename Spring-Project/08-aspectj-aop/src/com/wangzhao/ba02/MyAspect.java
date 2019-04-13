package com.wangzhao.ba02;

/**
 * ClassName:MyAspect
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:42
 * @Author:wangzhao
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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

    /**
     * @AfterReturn : 后置通知，在目标方法之后执行
     *              属性： 1.value ,表示切入点表达式
     *                     2.returning ,自定义的变量名，表示目标方法的返回值。自定义的变量名需要和通知方法的参数名一样
     *
     *          后置通知的特点：
     *                     1.在目标方法之后执行
     *                     2.能够获取到目标方法的执行结果，还可以对执行结果做修改
     *                          1）目标方法返回值是简单类型（String 和 java基本数据类型），在通知方法中修改返回值不会影响目标方法的最终结果
     *                          2）目标方法返回值非简单类型的，在通知方法中修改其属性值，能够影响目标方法的执行的最终结果
     *                     3.不会影响目标方法的执行
     *          Object result = doOther();
     */

    /**
     *  Object result = doOther2(); result 是对象
     *  myAfterReturning(result); 传地址
     */

    //  通知方法中可以有参数JoinPoint,如果通知方法中有多个参数，JoinPoint一定是第一个参数
    @AfterReturning(value="execution(* *..SomeServiceImpl.doOther2(..))",returning ="result")
    public void myAfterReturning(JoinPoint jp,Object result){
            System.out.println("获取方法切入点的方法签名："+jp.getSignature());
            //修改目标方法的执行结果
            if(result != null){
                Student student = (Student)result;
                student.setName("张三");
                student.setAge(20);
            }
            //执行后置通知，例如处理事务
            System.out.println("后置通知，在目标方法执行后执行，能够获取到目标方法的执行结果："+result);
    }

    /**
     *  Object result = doOther2(); result 是字符串
     *  myAfterReturning(result)；传值
     */
  /*  @AfterReturning(value="execution(* *..SomeServiceImpl.doOther(..))",returning ="result")
    public void myAfterReturning(Object result){
        //修改目标方法的执行结果
        if(result != null){
            String str = (String)result;
            result = "hello " + str.toUpperCase();
        }
        //执行后置通知，例如处理事务
        System.out.println("后置通知，在目标方法执行后执行，能够获取到目标方法的执行结果："+result);
    }*/
}
