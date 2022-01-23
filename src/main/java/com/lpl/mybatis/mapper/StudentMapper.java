package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.Student;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface StudentMapper {
    // 按照查询嵌套查询
    List<Student> getStudents();
    // 按照结果嵌套查询
    List<Student> getStudents2();
}
