package com.wangzhao.servlet;

import com.wangzhao.pojo.Student;
import com.wangzhao.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName:${NAME}
 * Package:${PACKAGE_NAME}
 * Description:
 *
 * @Date:2019/3/11 11:13
 * @Author:wangzhao
 */
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求参数
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));

        //创建Spring容器对象
        String configLocation = "applicationContext.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(configLocation);
        System.out.println(ac);

        //从容器中获取对象
        StudentService service = (StudentService) ac.getBean("studentService");

        //调用service方法
        Student stu = new Student();
        stu.setName(name);
        stu.setAge(age);
        service.addStudent(stu);

        //指定显示处理结果的页面
        request.getRequestDispatcher("/result.jsp").forward(request,response);
    }
}
