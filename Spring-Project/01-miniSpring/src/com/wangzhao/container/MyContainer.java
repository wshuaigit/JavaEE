package com.wangzhao.container;


import java.io.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:MyContainer
 * Package:com.wangzhao.container
 * Description: 读取MyObject.txt文件
 *              1.使用反射创建对象
 *              2.给对象的属性（依赖对象）赋值
 *
 * @Date:2019/3/5 19:54
 * @Author:wangzhao
 */
public class MyContainer {
    //使用集合保存创建好的对象
    private Map<String,Object> map = new HashMap<>();

    public MyContainer(File file) throws IOException, NoSuchFieldException, IllegalAccessException {
        init(file);
    }

    //从Map中获取程序中使用对象
    public Object getBean(String name){
        Object object = null;
        if(map.containsKey(name)){
            object = map.get(name);
        }
        return object;
    }

    /**
     * 读取文件MyObject.txt
     * @param file
     */
    private void init(File file) throws IOException, NoSuchFieldException, IllegalAccessException {
        FileReader reader = new FileReader(file);
        BufferedReader br = new BufferedReader(reader);
        String line = null;
        while((line = br.readLine())!=null){
            /*
                service=com.wangzhao.service.UserServiceImpl
                myUserMySQLDao=com.wangzhao.dao.UserDaoMySQLImpl
                service#userDao=myUserOracleDao
             */
            String[] data = line.split("=");
            String left = data[0];
            String right = data[1];

            //区分最后一行数据
            if(left.indexOf("#") > 0){
                //最后一行数据
                String ref[] = left.split("#");
                String refLeft = ref[0];
                String refRight = ref[1];

                //从Map中获取对象
                Object bean = map.get(refLeft);
                //反射机制获取Class
                Class clazz = bean.getClass();
                //获取要修改的属性
                Field field = clazz.getDeclaredField(refRight.split("=")[0]);

                //允许属性赋值
                field.setAccessible(true);
                field.set(bean,map.get(right));

            }else {
                //使用反射创建对象
                Object object = makeObject(right);
                //创建好的对象放入Map
                map.put(left,object);
            }

        }
    }

    private Object makeObject(String className){
        Object object = null;
        try {
            //调用类的无参构造创建对象
            object = Class.forName(className).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}
