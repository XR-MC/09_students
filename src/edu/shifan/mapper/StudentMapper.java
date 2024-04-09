package edu.shifan.mapper;

import edu.shifan.pojo.Student;

import java.util.List;

/**
 * 映射接口
 */
public interface StudentMapper {
    /**
     * 新增学生信息到数据库中
     * @param student
     * @return
     */
    int add(Student student);

    /**
     * 查询所有学生信息
     * @return
     */

    int update(Student student);
    List<Student> findAll();

    //按id查找学生信息
    Student findById(int id);
}
