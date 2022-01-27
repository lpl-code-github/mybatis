import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Blog;
import com.lpl.mybatis.mapper.BlogMapper;
import com.lpl.mybatis.utils.IdUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
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
        System.out.println("条件只有author-----R--------------");
        System.out.println(blogs3);

        session.close();
    }
}
