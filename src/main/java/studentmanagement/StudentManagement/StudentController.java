package studentmanagement.StudentManagement;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class StudentController {

  private final StudentRepository repository;
  private final StudentCourseRepository courseRepository;


  private List<Student> studentList = new ArrayList<>();
  private List<StudentCourse> courseList = new ArrayList<>();

  private Long studentIdCounter = 1L;
  private Long courseIdCounter = 1L;


  public StudentController(StudentRepository studentRepository,
      StudentCourseRepository courseRepository) {
    this.repository = studentRepository;
    this.courseRepository = courseRepository;
  }

  // 受講生登録
//  @PostMapping("/student")
//  public String addStudent(
//      @RequestParam String fullName,
//      @RequestParam(required = false) String furigana,
//      @RequestParam(required = false) String nickname,
//      @RequestParam String email,
//      @RequestParam(required = false) String region,
//      @RequestParam int age,
//      @RequestParam String gender) {
//
//    Student student = new Student(
//        studentIdCounter++, fullName, furigana, nickname, email, region, age, gender
//    );
//    studentList.add(student);
//    return "Student added: " + fullName;
//  }

  // 受講生一覧取得
  @GetMapping("/students")
  public List<Student> getAllStudents() {
    //return studentList;
    return (List<Student>) repository.findAll();
  }

   // 受講生コース登録エンドポイントを統一
 @PostMapping("/students_courses")
 public String addStudentCourse(
      @RequestParam Long studentId,
      @RequestParam String courseName,
      @RequestParam String startDate,
      @RequestParam String expectedEndDate) {

    boolean studentExists = studentList.stream().anyMatch(s -> s.getId().equals(studentId));
    if (!studentExists) {
      return "Error: Student ID not found.";
    }

    StudentCourse course = new StudentCourse(
        courseIdCounter++, studentId, courseName, startDate, expectedEndDate
    );
    courseList.add(course);
    return "Course added for student ID " + studentId + ": " + courseName;
  }

  // 受講生コース一覧取得
  @GetMapping("/students_courses")
  public List<StudentCourse> getAllCourses() {
    return courseRepository.findAll();
  }
}
