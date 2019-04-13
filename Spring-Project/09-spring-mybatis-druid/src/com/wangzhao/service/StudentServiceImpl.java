package com.wangzhao.service;

import com.wangzhao.dao.StudentDao;
import com.wangzhao.pojo.Student;

import java.util.List;

/**
 * ClassName:StudentServiceImpl
 * Package:com.wangzhao.service
 * Description:
 *
 * @Date:2019/3/10 20:21
 * @Author:wangzhao
 */
public class StudentServiceImpl implements StudentService{
    //引用类型
    private StudentDao stuDao;

    //Ioc的设值注入
    public void setStuDao(StudentDao stuDao) {
        this.stuDao = stuDao;
    }

    @Override
    public int addStudent(Student student) {
        return stuDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudent() {
        return stuDao.selectStudents();
    }
}
