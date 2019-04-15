package com.wangzhao.exception;

/**
 * ClassName:MyUserException
 * Package:com.wangzhao.exception
 * Description:
 *
 * @Date:2019/3/23 16:29
 * @Author:wangzhao
 */
public class MyUserException extends Exception{
    public MyUserException(){
        super();
    }
    public MyUserException(String str){
        super(str);
    }
}
