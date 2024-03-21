package zhangtaouc.springboot2.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import zhangtaouc.springboot2.Entity.Student;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @Select("select name , address from student")
    List<Student> selectAll();

    @Select("select name , address from student where name = #{name}")
    List<Student> getStudentByName(String name);

    @Insert("insert into student values(#{name}, #{address})")
    int addStudent(Student student);

    @Update("update student set name=#{name}, address=#{address} where name=#{name}")
    int updateStudent(Student student);

    @Delete("delete from student where name= #{name}")
    int deleteStudent(String name);
}
