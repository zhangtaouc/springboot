import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zhangtaouc.springboot2.Entity.Student;
import zhangtaouc.springboot2.Mapper.StudentMapper;
import zhangtaouc.springboot2.Springboot2Application;

import java.util.List;

@RunWith(SpringRunner.class)
// 如果在项目的主包（zhangtaouc.springboot2）下面，则不用写
@SpringBootTest(classes = Springboot2Application.class)
public class TestService {
 // 下面就是测试项

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void add() {
       List<Student> studentList = studentMapper.selectAll();
        System.out.println(JSON.toJSONString(studentList));
    }
}
