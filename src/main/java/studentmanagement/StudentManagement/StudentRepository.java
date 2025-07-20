package studentmanagement.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students WHERE name = #{name}")
  List<Student> searchByName(Student name);


  @Select("SELECT * FROM students")
  List<Student> findAll();

  @Insert("INSERT INTO students(full_name, furigana, nickname, email, region, age, gender) " +
      "VALUES(#{fullName}, #{KanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex})")
  void insertStudent(Student student);
}
