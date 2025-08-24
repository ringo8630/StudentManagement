package studentmanagement.domain;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import studentmanagement.data.Student;
import studentmanagement.data.StudentCourse;

@Getter
@Setter
public class StudentDetail {

  private Student student;
  private List<StudentCourse> studentCourses;

}
