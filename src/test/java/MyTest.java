import com.github.pagehelper.PageHelper;
import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Member;
import com.lpl.mybatis.domain.User;
import com.lpl.mybatis.mapper.MemberMapper;
import com.lpl.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class MyTest {

    // 导包：org.apache.log4j.Logger
    static Logger logger = Logger.getLogger(MyTest.class);

    @Test
    /**
     * 测试查询全部
     */
    public void select(){
        logger.info("info:进入查询全部select方法");
        SqlSession session = MybatisConfig.getSession();
        // 方法一
        // List<User> list = session.selectList("com.lpl.mybatis.mapper.UserMapper.selectUser");
        // 方法二
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.selectUser();
        // 打印
        for (User user: list) {
            // System.out.println(user);
            logger.debug(user);
        }
        // 关闭连接
        session.close();
    }
    @Test
    /**
     * 测试分页查询
     */
    public void selectByPage(){
        logger.info("info:进入分页查询方法");
        SqlSession session = MybatisConfig.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        // 分页查询，查询第二页，每页显示2条数据
        PageHelper.startPage(2,2);
        List<User> list = mapper.selectUser();
        // 打印
        for (User user: list) {
            // System.out.println(user);
            logger.debug(user);
        }
        // 关闭连接
        session.close();
    }
    @Test
    /**
     * 测试根据id查询
     */
    public void selectById(){
        logger.info("info:进入根据id查询selectById方法");
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        // 打印
        logger.debug(user);
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试通过用户名和密码查询
     */
    public void selectByNameAndPwd(){
        logger.info("info:进入通过用户名和密码查询selectByNameAndPwd方法");
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
        logger.debug(user);
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试添加
     */
    public void addUser(){
        logger.info("info:进入添加addUser方法");
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User(4,"testUser","test");
        int i = mapper.addUser(user);
        if (i > 0){
            logger.debug("添加成功，i="+i);
        }else {
            logger.debug("添加失败，i="+i);
        }
        // 提交事务
        // session.commit();
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试更新
     */
    public void updateUser(){
        logger.info("info:进入更新updateUser方法");
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.selectById(1);
        user.setPwd("654321");
        int i = mapper.updateUser(user);
        if (i > 0){
            logger.debug("更新成功，i="+i);
            User user1 = mapper.selectById(1);
            logger.debug("更新后的信息"+user1);
        }else {
            logger.debug("更新失败，i="+i);
        }
        // 提交事务
        // session.commit();
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试删除
     */
    public void deleteUser(){
        logger.info("info:进入删除deleteUser方法");
        SqlSession session = MybatisConfig.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.deleteUser(4);
        if (i > 0){
            logger.debug("删除成功，i="+i);
        }else {
            logger.debug("删除失败，i="+i);
        }
        // 提交事务
        // session.commit();
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试模糊查询
     */
    public void selectLike(){
        logger.info("info:进入模糊查询方法");
        SqlSession session = MybatisConfig.getSession();

        UserMapper mapper = session.getMapper(UserMapper.class);
        // Java代码中添加sql通配符
        List<User> list = mapper.selectLike("%李%");
        // 打印
        for (User user: list) {
            logger.debug(user);
        }
        // 关闭连接
        session.close();
    }

    @Test
    /**
     * 测试 #{}和${}
     */
    public void findByUsername(){
        SqlSession session = MybatisConfig.getSession();

        MemberMapper mapper = session.getMapper(MemberMapper.class);

        List<Member> memberList = mapper.findByUsername("%李%");
        List<Member> memberList2 = mapper.findByUsername2("李");

        System.out.println("memberList: ");
        for (Member member : memberList) {
            System.out.println(member);
        }

        System.out.println("memberList2: ");

        for (Member member : memberList2) {
            System.out.println(member);
        }

        // session.commit();// 提交事务
        session.close();
    }

    @Test
    /**
     * sql注入测试
     */
    public void findByUsername2(){
        SqlSession session = MybatisConfig.getSession();

        MemberMapper mapper = session.getMapper(MemberMapper.class);

        List<Member> memberList = mapper.findByUsername(" aaa' or 1=1 -- ");
        List<Member> memberList2 = mapper.findByUsername2(" aaa' or 1=1 -- ");

        System.out.println("memberList: ");
        for (Member member : memberList) {
            System.out.println(member);
        }

        System.out.println("memberList2: ");

        for (Member member : memberList2) {
            System.out.println(member);
        }

        // session.commit();// 提交事务
        session.close();
    }

    @Test
    /**
     * 测试删除的sql注入
     */
    public void deleteMember(){
        SqlSession session = MybatisConfig.getSession();
        MemberMapper mapper = session.getMapper(MemberMapper.class);
        int i = mapper.deleteById("359b3258b19' or 1=1 -- ");
        if (i > 0){
            logger.debug("删除成功，i="+i);
        }else {
            logger.debug("删除失败，i="+i);
        }
        // 提交事务
        // session.commit();
        // 关闭连接
        session.close();
    }
}
