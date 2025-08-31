package studentmanagement.controller;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import studentmanagement.controller.converter.StudentConverter;
import studentmanagement.data.Student;
import studentmanagement.data.StudentCourse;
import studentmanagement.domain.StudentDetail;
import studentmanagement.service.StudentService;

@RestController
public class StudentController {

  private StudentService service;
  private StudentConverter converter;

  @Autowired
  public StudentController(StudentService service, StudentConverter converter) {
    this.service = service;
    this.converter = converter;
  }

  // 🔹 受講生一覧取得（全件検索）
  @GetMapping("/studentList")
  public List<StudentDetail> getStudentList() {
    List<Student> students = service.searchStudentList();
    List<StudentCourse> studentCourses = service.searchStudentCoursesList();

    return converter.convertStudentDetails(students,
        studentCourses);
  }



  // 🔹 受講生一覧取得（全件検索）
  @GetMapping("/studentList30")
  public List<Student> getStudentList30() {
    return service.searchStudentList30();
  }

  // 🔹 受講生コース一覧取得（全件検索）
  @GetMapping("/StudentCourseList")
  public List<StudentCourse> getStudentCourseList() {
    return service.searchStudentCoursesList();
  }

  // 🔹 受講生コース登録（新規登録）
  @PostMapping("/students_courses")
  public String addStudentCourse(
      @RequestParam Long studentId,
      @RequestParam String courseName,
      @RequestParam String startDate,
      @RequestParam String expectedEndDate) {
    return service.registerStudentCourses(studentId, courseName, startDate, expectedEndDate);
  }
}
