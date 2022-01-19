package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@Mapper
public interface UserMapper {
    // 查询全部
    List<User> selectUser();
    // 根据id查询
    User selectById(int id);
    // 根据密码和用户名查询
    User selectByNameAndPwd(@Param("name") String name ,@Param("pwd") String pwd);
    // 使用map集合传参
    User selectByNameAndPwd2(Map<String,Object> map);
    // 添加
    int addUser(User user);
    // 更新
    int updateUser(User user);
}
