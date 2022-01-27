package com.lpl.mybatis.domain;

import lombok.Data;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class Teacher {
    private int id;
    private String name;
    private List<Student> students;
}
