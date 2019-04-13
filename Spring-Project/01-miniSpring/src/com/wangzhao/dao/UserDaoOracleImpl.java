package com.wangzhao.dao;

/**
 * ClassName:UserDaoOracleImpl
 * Package:com.wangzhao.dao
 * Description:
 *
 * @Date:2019/3/5 19:40
 * @Author:wangzhao
 */
public class UserDaoOracleImpl implements UserDao{
    @Override
    public void insertUser() {
        System.out.println("执行了Oracle的插入操作");
    }
}
