package zhangtaouc.springboot2;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import zhangtaouc.springboot2.Entity.Student;
import zhangtaouc.springboot2.Mapper.StudentMapper;
import zhangtaouc.springboot2.Response.Result;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private Result result;

    @RequestMapping("/getAll")
    public String getAll() {
        result.setState(200);
        result.setRetData(studentMapper.selectAll());
        result.setRetCode("00000");
        return JSON.toJSONString(result) ;
    }

    @RequestMapping("/getStudentByName")
    public String getStudentByName(String name) {
        result.setState(200);
        result.setRetData(studentMapper.getStudentByName(name));
        result.setRetCode("00000");
        return JSON.toJSONString(result) ;
    }



    @RequestMapping(value = "/addStudent",method = RequestMethod.POST)
    public String addStudent(@RequestBody Student student) {
        System.out.println("获取到学生" + student);
        int num = studentMapper.addStudent(student);
        if (num == 1) {
            result.setState(200);
            result.setRetData("添加成功");
            result.setRetCode("00000");
        } else {
            result.setState(200);
            result.setRetData("添加失败");
            result.setRetCode("00001");
        }
        return JSON.toJSONString(result) ;
    }
}
