package studentmanagement.service;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.web.bind.annotation.GetMapping;
import studentmanagement.Repository.StudentRepository;
import studentmanagement.data.Student;
import studentmanagement.data.StudentCourse;

@Service
public class StudentService {

  private StudentRepository repository;

@Autowired
  public StudentService(StudentRepository repository) {
    this.repository = repository;
  }

  private List<Student> studentList = new ArrayList<>();
  private List<StudentCourse> courseList = new ArrayList<>();

  // 受講生一覧（仮実装）
  public List<Student> searchStudentList() {
    return repository.findAll();
  }

    //絞り込みをする。年齢が30代の人のみを抽出する。
    public List<Student> searchStudentList30() {
      return repository.find30().stream()
          .filter(s -> s.getAge() >= 30 && s.getAge() <= 39)
          .collect(Collectors.toList());
    }

  private boolean isIn30s(Student s) {
    Integer age = s.getAge();
    return age != null && age >= 30 && age <= 39;
  }



  // 受講生コース一覧（仮実装）
  public List<StudentCourse> searchStudentCourseList() {
    return repository.findCourse();
  }

  // 追加: Javaコースのみ取得
  public List<StudentCourse> searchJavaCourseList() {
    return repository.findJavaCourses(); // リポジトリの SQL で絞り込む
  }




  // 受講生コース登録（仮実装）
  public String registerStudentCourse(Long studentId, String courseName, String startDate, String expectedEndDate) {
    // studentIdの存在チェック（簡易版）
    boolean studentExists = studentList.stream().anyMatch(s -> s.getId().equals(studentId));
    if (!studentExists) {
      return "Error: Student ID not found.";
    }

    Long newId = (long) (courseList.size() + 1);
    StudentCourse course = new StudentCourse(newId, studentId, courseName, startDate, expectedEndDate);
    courseList.add(course);

    return "Course added for student ID " + studentId + ": " + courseName;
  }


}
