package com.wangzhao.service;

import com.wangzhao.pojo.Student;

import java.util.List;

/**
 * ClassName:StudentService
 * Package:com.wangzhao.service
 * Description:
 *
 * @Date:2019/3/10 20:20
 * @Author:wangzhao
 */
public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudent();
}
