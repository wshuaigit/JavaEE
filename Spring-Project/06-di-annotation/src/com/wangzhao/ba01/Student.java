package com.wangzhao.ba01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *  @Component:创建对象，默认创建的是单例对象
 *      属性：value ,表示对象的id
 *      位置：在类的上面，表示创建该类的对象
 *
 *  @Component(value = "myStudent")等同于
 *      <bean id="myStudent" class="com.wangzhao.ba01.Student"></bean>
 *
 *  和@Component功能相同的其他注解
 *      1、@Repository : 放在Dao层实现类的上面，创建Dao对象
 *      2、@Service : 放在Service层实现类的上面，创建Service对象
 *      3、@Controller : 放在处理器类的上面，创建控制器对象
 */
//@Component(value = "myStudent")
@Repository
//省略value
//@Component("myStudent")

//不知道对象的名称，有框架生成默认的名称：类名的首字母小写
@Component
public class Student {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
