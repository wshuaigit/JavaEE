package com.wangzhao.dao;

import com.wangzhao.pojo.Student;

import java.util.List;

/**
 * ClassName:StudentDao
 * Package:com.wangzhao.dao
 * Description:
 *
 * @Date:2019/3/10 19:25
 * @Author:wangzhao
 */
public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
