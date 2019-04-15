package com.wangzhao.dao;

import com.wangzhao.beans.Student;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * ClassName:StudentDao
 * Package:com.wangzhao.dao
 * Description:
 *
 * @Date:2019/3/26 19:26
 * @Author:wangzhao
 */
public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();

}
