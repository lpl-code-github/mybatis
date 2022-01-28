import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Blog;
import com.lpl.mybatis.mapper.BlogMapper;
import com.lpl.mybatis.utils.IdUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */

public class MyTest3 {
    /**
     * 初始化数据（插入数据）
     */
    @Test
    public void addInitBlog() {
        SqlSession session = MybatisConfig.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IdUtil.getId())
                .setTitle("blog1")
                .setAuthor("张三")
                .setCreateTime(new Date())
                .setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId())
                .setTitle("blog2");
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId())
                .setTitle("blog3");
        mapper.addBlog(blog);

        blog.setId(IdUtil.getId())
                .setTitle("blog4");
        mapper.addBlog(blog);

        session.close();
    }

    /**
     * 测试需求1
     */
    @Test
    public void testQueryBlogIf() {
        SqlSession session = MybatisConfig.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("title", "blog1");
        map.put("author", "张三");
        List<Blog> blogs1 = mapper.queryBlogIf(map);
        System.out.println("条件title和author都存在-----------");
        System.out.println(blogs1);

        map.put("title", "blog2");
        map.remove("author");
        List<Blog> blogs2 = mapper.queryBlogIf(map);
        System.out.println("条件只有title--------------------");
        System.out.println(blogs2);

        map.remove("title");
        map.put("author", "张三");
        List<Blog> blogs3 = mapper.queryBlogIf(map);
        System.out.println("条件只有author--------------------");
        System.out.println(blogs3);

        session.close();
    }

    /**
     * 测试需求2
     */
    @Test
    public void testUpdateBlog() {
        SqlSession session = MybatisConfig.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, String> map = new HashMap<String, String>();

        // 对id为63ac8f80710e4d178f6b9dd22d3968a2的博客更新title为updateTitle1,author更新为updateAuthor2
        map.put("title", "updateTitle1");
        map.put("author", "updateAuthor2");
        map.put("id", "63ac8f80710e4d178f6b9dd22d3968a2");
        mapper.updateBlog(map);

        // 对id为63ac8f80710e4d178f6b9dd22d3968a2的博客更新title为updateTitle2,author不更新
        map.put("title", "updateTitle2");
        map.remove("author");
        map.put("id", "81e38abe82f945178801e2eb30ed2dff");
        mapper.updateBlog(map);

        // 对id为63ac8f80710e4d178f6b9dd22d3968a2的博客不更新title,author更新为updateAuthor3
        map.remove("title");
        map.put("author", "updateAuthor3");
        map.put("id", "b0d8c5e6f5cb4321918cb9b5f727e681");
        mapper.updateBlog(map);

        session.close();
    }

    /**
     * 测试choose
     */
    @Test
    public void testQueryBlogChoose() {
        SqlSession session = MybatisConfig.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap<String, Object> map = new HashMap<String, Object>();
        // 无条件
        List<Blog> blogs1 = mapper.queryBlogChoose(map);
        System.out.println("无条件-------------------------");
        System.out.println(blogs1);

        // 只有一个条件views
        map.put("views", 9999);
        List<Blog> blogs2 = mapper.queryBlogChoose(map);
        System.out.println("只有一个条件views-----------------");
        System.out.println(blogs2);

        // 含有两个条件title和view
        map.put("title", "blog3");
        List<Blog> blogs3 = mapper.queryBlogChoose(map);
        System.out.println("含有两个条件title和view-----------");
        System.out.println(blogs3);

        // 含有两个条件author和view
        map.remove("title");
        map.put("author", "张三");
        List<Blog> blogs4 = mapper.queryBlogChoose(map);
        System.out.println("含有两个条件author和view-----------");
        System.out.println(blogs4);

        // 含有两个条件title和author
        map.put("title", "blog3");
        map.remove("views");
        List<Blog> blogs5 = mapper.queryBlogChoose(map);
        System.out.println("含有两个条件title和author-----------");
        System.out.println(blogs5);

        // 含有三个条件title、author、view
        map.put("title", "blog3");
        map.put("views", 9999);
        List<Blog> blogs6 = mapper.queryBlogChoose(map);
        System.out.println("含有三个条件title、author、view-----------");
        System.out.println(blogs6);

        session.close();
    }

    /**
     * 测试foreach
     */
    @Test
    public void testQueryBlogForeach() {
        SqlSession session = MybatisConfig.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(5);
        ids.add(6);
        ids.add(7);
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);

        System.out.println(blogs);

        session.close();
    }
}
