package test;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

/**
 * ClassName:MyTest
 * Package:com.wangzhao.test
 * Description:
 *
 * @Date:2019/3/5 19:36
 * @Author:wangzhao
 */
public class MyTest {
    public static void main(String[] args){
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService service = (UserService) ac.getBean("myUserService");
        service.addUser();
    }
}
