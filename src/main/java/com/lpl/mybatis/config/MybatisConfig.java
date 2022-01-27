package com.lpl.mybatis.config;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;


/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */

public class MybatisConfig {
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try{
            String resource = "config/MybatisConfig.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 获取SqlSession连接
    public static SqlSession getSession(){
        return getSession(true); // 事务自动提交
    }

    public static SqlSession getSession(boolean flags){
        return sqlSessionFactory.openSession(flags);
    }
}
