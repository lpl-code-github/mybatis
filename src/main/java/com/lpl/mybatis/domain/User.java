package com.lpl.mybatis.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

}
