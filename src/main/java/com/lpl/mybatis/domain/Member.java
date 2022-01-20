package com.lpl.mybatis.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class Member {
    private String id;
    private String username;
    private Date birthday;
    private String sex;
    private String address;
}
