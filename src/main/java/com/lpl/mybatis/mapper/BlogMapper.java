package com.lpl.mybatis.mapper;

import com.lpl.mybatis.domain.Blog;

import java.util.List;
import java.util.Map;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public interface BlogMapper {
    int addBlog(Blog blog);
    // 需求1
    List<Blog> queryBlogIf(Map map);
}
