package studentmanagement.StudentManagement;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> search();

  @Select("SELECT * FROM students WHERE full_name = #{name}")
  Student searchByName(String name);

  @Insert("INSERT INTO students(full_name, furigana, nickname, email, region, age, gender) " +
      "VALUES(#{fullName}, #{furigana}, #{nickname}, #{email}, #{region}, #{age}, #{gender})")
  void insertStudent(Student student);
}
