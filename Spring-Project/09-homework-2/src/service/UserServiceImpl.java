package service;


import dao.UserDao;
import dao.UserDaoOracleImpl;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName:UserServiceImpl
 * Package:com.wangzhao.service
 * Description: 依赖关系：class A 使用了class B 的属性或者方法。class A 依赖class B
 *              UserServiceImpl 的addUser方法的实现需要依赖UserDao对象
 *
 * @Date:2019/3/5 19:31
 * @Author:wangzhao
 */
@Service("myUserService")
public class UserServiceImpl implements UserService{

    @Resource(name="mySQLDao")
    private UserDao userDao;


    @Override
    public void addUser() {
        //调用Dao类的方法，实现插入操作
        userDao.insertUser();
    }

}
