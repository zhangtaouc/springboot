package zhangtaouc.springboot2;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zhangtaouc.springboot2.Entity.Student;
import zhangtaouc.springboot2.Mapper.StudentMapper;
import zhangtaouc.springboot2.Response.Result;

import java.util.List;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
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

    @RequestMapping(value = "/updateStudent",method = RequestMethod.POST)
    public String updateStudent(@RequestBody Student student) {
        System.out.println("获取到学生" + student);
        int num = studentMapper.updateStudent(student);
        if (num == 1) {
            result.setState(200);
            result.setRetData("更新成功");
            result.setRetCode("00000");
        } else {
            result.setState(200);
            result.setRetData("更新失败");
            result.setRetCode("00001");
        }
        return JSON.toJSONString(result) ;
    }

    @RequestMapping(value = "/deleteStudent",method = RequestMethod.DELETE)
    public String deleteStudent(String name) {
        System.out.println("获取到的名字" + name);
        List<Student> students = studentMapper.getStudentByName(name);
        if (students.size() > 0) {
            int num = studentMapper.deleteStudent(name);
            if (num == 1) {
                result.setState(200);
                result.setRetData("删除成功");
                result.setRetCode("00000");
            } else {
                result.setState(200);
                result.setRetData("删除失败");
                result.setRetCode("00001");
            }
        } else {
            result.setState(200);
            result.setRetData("删除失败，没有这个人");
            result.setRetCode("00002");
        }
        return JSON.toJSONString(result) ;
    }

    @RequestMapping("/getStudentListByName")
    public String getStudentListByName(String name) {
        result.setState(200);
        List<Student> list = studentMapper.getStudentListByName(name);
        System.out.println("获取道德数据"+list);
        result.setRetData(list);
        result.setRetCode("00000");
        return JSON.toJSONString(result) ;
    }

}
