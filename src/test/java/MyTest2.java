import com.lpl.mybatis.config.MybatisConfig;
import com.lpl.mybatis.domain.Student;
import com.lpl.mybatis.domain.Teacher;
import com.lpl.mybatis.domain.User;
import com.lpl.mybatis.mapper.StudentMapper;
import com.lpl.mybatis.mapper.TeacherMapper;
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
     * 测试查询全部[多对一]
     */
    public void select() {
        SqlSession session = MybatisConfig.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudents();

        for (Student student : list) {
            System.out.println(student);
        }

        session.close();
    }

    @Test
    /**
     * 测试查询全部2[多对一]
     */
    public void select2() {
        SqlSession session = MybatisConfig.getSession();
        StudentMapper mapper = session.getMapper(StudentMapper.class);

        List<Student> list = mapper.getStudents2();

        for (Student student : list) {
            System.out.println(student);
        }

        session.close();
    }

    /**
     * 测试查询某老师(下的学生)[一对多]
     */
    @Test
    public void select3() {
        SqlSession session = MybatisConfig.getSession();
        TeacherMapper mapper = session.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);

        session.close();
    }
}
