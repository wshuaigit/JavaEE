package com.wangzhao.test;

import com.wangzhao.container.MyContainer;
import com.wangzhao.service.UserService;
import com.wangzhao.service.UserServiceImpl;

import java.io.*;
import java.util.Properties;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.test
 * Description:
 *
 * @Date:2019/3/5 19:36
 * @Author:wangzhao
 */
public class MyTest {
    public static void main(String[] args) throws IOException, NoSuchFieldException, IllegalAccessException {
      /*  //创建Service对象
        UserService service = new UserServiceImpl();
        service.addUser();*/

        //使用配置文件表示对象的信息，使用MyContainer完成对象创建，属性赋值
        String path = MyTest.class.getResource("/").getPath();
        File file = new File(path,"MyObject.txt");
        MyContainer container = new MyContainer(file);

        //从Container中获取对象
        UserService service = (UserService)container.getBean("service");
        service.addUser();

    }
}
