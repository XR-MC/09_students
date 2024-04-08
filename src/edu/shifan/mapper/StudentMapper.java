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
    List<Student> findAll();
}
