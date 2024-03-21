package zhangtaouc.springboot2.Mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import zhangtaouc.springboot2.Entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
    List<Student> getStudentByName(String name);

    @Select("select name , address from student where name like #{name}")
    List<Student> getStudentListByName(String name);
    int addStudent(Student student);
    int updateStudent(Student student);
    int deleteStudent(String name);
}
