package zhangtaouc.springboot2;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zhangtaouc.springboot2.Mapper.StudentMapper;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/getAll")
    public String getAll() {
        return JSON.toJSONString(studentMapper.selectAll()) ;
    }
}
