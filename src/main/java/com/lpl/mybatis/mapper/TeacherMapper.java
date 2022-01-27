package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.Teacher;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface TeacherMapper {
    // 获取指定老师，一个老师包含多个学生
    Teacher getTeacher(int id);

    Teacher getTeacher2(int id);
}
