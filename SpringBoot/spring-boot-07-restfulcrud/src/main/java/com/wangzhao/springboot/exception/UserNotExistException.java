package com.wangzhao.springboot.exception;

public class UserNotExistException extends Exception{

    public UserNotExistException(){

    }

    public UserNotExistException(String str){
        super(str);
    }
}
