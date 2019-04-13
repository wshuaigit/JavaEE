package com.wangzhao.ba01;

/**
 * ClassName:SomeServiceImpl
 * Package:com.wangzhao.ba01
 * Description:
 *
 * @Date:2019/3/8 16:41
 * @Author:wangzhao
 */
public class SomeServiceImpl implements SomeService{
    @Override
    public void doSome() {
        System.out.println("执行业务方法doSome()");
    }

    @Override
    public void doOther(int i)  {
        System.out.println("执行业务方法doOther()");
        System.out.println(i);
    }
}
