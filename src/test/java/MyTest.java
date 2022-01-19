import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.User;
import com.lpl.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class MyTest {
    @Test
    public void select(){
        SqlSession session = MybatisConfig.getSession();
        // 方法一
        // List<User> list = session.selectList("com.lpl.mybatis.mapper.UserMapper.selectUser");
        // 方法二
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.selectUser();
        // 打印
        for (User user: list) {
            System.out.println(user);
        }
        // 关闭连接
        session.close();
    }

    @Test
    public void selectById(){
        SqlSession session = MybatisConfig.getSession();
        // 方法二
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        // 打印
        System.out.println(user);
        // 关闭连接
        session.close();
    }
}
