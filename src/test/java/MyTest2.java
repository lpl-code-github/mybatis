import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Student;
import com.lpl.mybatis.domain.User;
import com.lpl.mybatis.mapper.StudentMapper;
import com.lpl.mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class MyTest2 {
    @Test
    /**
     * 测试查询全部
     */
    public void select(){
        SqlSession session = MybatisConfig.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudents();

        for (Student student: list) {
             System.out.println(student);
        }

        session.close();
    }
}
