package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.Member;
import com.lpl.mybatis.domain.User;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface MemberMapper {
    List<Member> findByUsername(String username);

    List<Member> findByUsername2(String username);

    int deleteById(String id);
}
