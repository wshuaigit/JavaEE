package com.wangzhao.exception;

/**
 * ClassName:NameException
 * Package:com.wangzhao.exception
 * Description:
 *
 * @Date:2019/3/23 16:30
 * @Author:wangzhao
 */
public class NameException extends MyUserException{
    public NameException() {
    }

    public NameException(String str) {
        super(str);
    }
}
