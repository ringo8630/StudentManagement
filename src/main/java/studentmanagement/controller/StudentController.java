package studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentmanagement.data.Student;
import studentmanagement.data.StudentCourse;
import studentmanagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;

  @Autowired
  public StudentController(StudentService service) {
    this.service = service;
  }

  // 🔹 受講生一覧取得（全件検索）
  @GetMapping("/studentList")
  public List<Student> getStudentList() {
    return service.searchStudentList();
  }

  // 🔹 受講生一覧取得（全件検索）
  @GetMapping("/studentList30")
  public List<Student> getStudentList30() {
    return service.searchStudentList30();
  }

  @GetMapping("/StudentCourseList") // 全件取得
  public List<StudentCourse> getAllStudentCourseList() {
    return service.searchStudentCourseList();
  }

  @GetMapping("/StudentCourseList/java") // Javaコースのみ取得
  public List<StudentCourse> getJavaCourseList() {
    return service.searchJavaCourseList();
  }

  // 🔹 受講生コース登録（新規登録）
  @PostMapping("/students_courses")
  public String addStudentCourse(
      @RequestParam Long studentId,
      @RequestParam String courseName,
      @RequestParam String startDate,
      @RequestParam String expectedEndDate) {
    return service.registerStudentCourse(studentId, courseName, startDate, expectedEndDate);
  }
}
