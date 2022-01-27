package com.lpl.mybatis.domain;

import lombok.Data;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class Student {
    private int id;
    private String name;
    private int tid;
    // 多个学生可以是同一个老师，即多对一
    private Teacher teacher;
}
