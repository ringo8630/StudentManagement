package studentmanagement.Repository;

import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import studentmanagement.data.Student;
import studentmanagement.data.StudentCourse;

/**
 * 受講生情報を扱うリポジトリ
 *
 * 全件検索や単一条件での検索、コース情報の検索を行えるクラスです。
 *
 */
@Mapper
public interface StudentRepository {

  @Select("SELECT * FROM students")
  List<Student> findAll(); // ← 全件検索

  @Select("SELECT * FROM students")
  List<Student> find30();

  // 🔹 Javaコースのみ取得
  @Select("SELECT * FROM students_courses WHERE course_name = 'Javaコース'")
  List<StudentCourse> findJavaCourses();

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> searchStudentsCourses();


  @Select("SELECT * FROM students WHERE name = #{name}")
  List<Student> searchByName(Student name);


  @Insert("INSERT INTO students(full_name, furigana, nickname, email, region, age, gender) " +
      "VALUES(#{fullName}, #{KanaName}, #{nickname}, #{email}, #{area}, #{age}, #{sex})")
  void insertStudent(Student student);

  @Select("SELECT * FROM students_courses")
  List<StudentCourse> findCourse();
}
