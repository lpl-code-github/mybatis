import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Blog;
import com.lpl.mybatis.mapper.BlogMapper;
import com.lpl.mybatis.mapper.TeacherMapper;
import com.lpl.mybatis.utils.IdUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;

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
}
