package zhangtaouc.springboot2.Mapper;
import org.apache.ibatis.annotations.Mapper;
import zhangtaouc.springboot2.Entity.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<Student> selectAll();
}
