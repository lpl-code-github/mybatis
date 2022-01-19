import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.User;
import com.lpl.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class MyTest {
    @Test
    /**
     * 测试查询全部
     */
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
    /**
     * 测试根据id查询
     */
    public void selectById(){
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        // 打印
        System.out.println(user);
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试通过用户名和密码查询
     */
    public void selectByNameAndPwd(){
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 通过parm传参
        // User user = mapper.selectByNameAndPwd("lpl","123456");
        // 通过map传参
        HashMap<String, Object> map = new HashMap<>();
        map.put("name","lpl");
        map.put("pwd","123456");
        User user = mapper.selectByNameAndPwd2(map);
        // 打印
        System.out.println(user);
        // 关闭连接
        session.close();
    }
}
