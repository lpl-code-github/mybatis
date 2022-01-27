package com.lpl.mybatis.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Data
public class Blog {
    private String id;
    private String title;
    private String author;
    private Date createTime;
    private int views;
}
