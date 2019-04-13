package service;


import dao.UserDao;
import dao.UserDaoOracleImpl;

/**
 * ClassName:UserServiceImpl
 * Package:com.wangzhao.service
 * Description: 依赖关系：class A 使用了class B 的属性或者方法。class A 依赖class B
 *              UserServiceImpl 的addUser方法的实现需要依赖UserDao对象
 *
 * @Date:2019/3/5 19:31
 * @Author:wangzhao
 */
public class UserServiceImpl implements UserService{

    //定义Dao对象
   // private UserDao userDao = new UserDaoMySQLImpl();
    private UserDao userDao = new UserDaoOracleImpl();


    @Override
    public void addUser() {
        //调用Dao类的方法，实现插入操作
        userDao.insertUser();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
