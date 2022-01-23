package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.Student;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface StudentMapper {
    List<Student> getStudents();
}
