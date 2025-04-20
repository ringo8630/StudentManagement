package studentmanagement.StudentManagement;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentRepository {

  @Select("SELECT name,age FROM student WHERE name = #{name}")
  Student searchByName(String name);


  @Insert("INSERT INTO student(name, age) values (#{name},#{age})")
  void registerStudent(String name, int age);

  @Update("UPDATE student SET age = #{age} WHERE name =#{name}")
  void updateStudent(String name,int age);

  @Delete("DELETE FROM student WHERE name = #{name}")
  void deleteStudent(String name);
}