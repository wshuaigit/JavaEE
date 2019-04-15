package com.es.dao;

import com.es.beans.Student;

/**
 * ClassName:LoginMapper
 * Package:com.es.dao
 * Description:
 *
 * @Date:2019/3/27 0:12
 * @Author:wangzhao
 */
public interface LoginMapper {
    /**
     *  根据学号进行登录
     */
    String loginDao(String stuNum);

    /**
     *  学生进行注册
     */
    int registerDao(String stuNum,String pwd);
}
