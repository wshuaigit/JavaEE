package com.wangzhao.serviceImpl;

import com.wangzhao.beans.Student;
import com.wangzhao.dao.StudentDao;
import com.wangzhao.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName:StudentServiceImpl
 * Package:com.wangzhao.serviceImpl
 * Description:
 *
 * @Date:2019/3/26 19:33
 * @Author:wangzhao
 */
@Service
public class StudentServiceImpl implements StudentService {
    /**
     *  引用类型,@Autowired,@Resource
     *  byname,byType
     */
    //byType
    @Autowired
    private StudentDao stuDao;

    @Override
    public int addStudent(Student student) {
        return stuDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudents() {
        return stuDao.selectStudents();
    }
}
