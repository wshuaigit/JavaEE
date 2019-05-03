package com.wangzhao.springboot.controller;

import com.wangzhao.springboot.dao.DepartmentDao;
import com.wangzhao.springboot.dao.EmployeeDao;
import com.wangzhao.springboot.entities.Department;
import com.wangzhao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.Map;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工返回列表页面
    @GetMapping("/emps")
    public String list(Model model){
        Collection<Employee> all = employeeDao.getAll();

        //放在请求域中
        model.addAttribute("emps",all);


        // thymeleaf 默认就会拼串
        // classpath:/thymeleaf/emp/list.html
        return "emp/list";
    }

    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面，查询出所有的部门在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);

        //来到添加页面
        return "emp/add";
    }

    //员工添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和javaBean入参的对象属性相同
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println("添加的员工信息："+employee);
        //保存员工信息
        employeeDao.save(employee);


        //来到员工列表页面
        // redirect: 表示重定向到一个地址 /代表当前项目路径
        // forward: 表示请求转发到一个地址
        return "redirect:/emps";
    }


    //来到修改页面，查出当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") Integer id,Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);

        //页面显示所有的部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments",departments);
        //回到修改页面(add是一个修改添加二合一的页面)
        return "emp/add";
    }


    //员工修改,需要提交员工id
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //员工删除
    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
