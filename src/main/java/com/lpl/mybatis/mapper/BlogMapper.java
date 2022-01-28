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
    // 需求1 根据title和author来查询博客，如果author为空，那么只根据title名字查询，反之，则根据author来查询
    List<Blog> queryBlogIf(Map map);
    // 需求2 根据id更新博客，如果title为空，那么只更新author，反之，只更新title
    int updateBlog(Map map);
    // choose
    List<Blog> queryBlogChoose(Map map);
}
