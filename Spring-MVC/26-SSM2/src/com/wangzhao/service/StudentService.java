package com.wangzhao.service;

import com.wangzhao.beans.Student;

import java.util.List;

/**
 * ClassName:StudentService
 * Package:com.wangzhao.service
 * Description:
 *
 * @Date:2019/3/26 19:32
 * @Author:wangzhao
 */
public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudents();
}
