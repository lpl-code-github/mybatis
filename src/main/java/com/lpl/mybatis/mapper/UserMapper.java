package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Mapper
public interface UserMapper {
    List<User> selectUser();
}
