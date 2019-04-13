package dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * ClassName:UserDaoMySQLImpl
 * Package:com.wangzhao.dao
 * Description: 对MySQL数据库的实现
 *
 * @Date:2019/3/5 19:28
 * @Author:wangzhao
 */

@Repository("mySQLDao")
public class UserDaoMySQLImpl implements UserDao{
    @Override
    public void insertUser() {
        System.out.println("执行对MySQL的插入操作");
    }
}
