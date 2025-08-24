package studentmanagement.StudentManagement;

public class StudentCourse {
  private Long id;
  private Long studentId;
  private String courseName;
  private String startDate;
  private String expectedEndDate;

  public StudentCourse(Long id, Long studentId, String courseName,
      String startDate, String expectedEndDate) {
    this.id = id;
    this.studentId = studentId;
    this.courseName = courseName;
    this.startDate = startDate;
    this.expectedEndDate = expectedEndDate;
  }

  public Long getId() { return id; }
  public Long getStudentId() { return studentId; }
  public String getCourseName() { return courseName; }
  public String getStartDate() { return startDate; }
  public String getExpectedEndDate() { return expectedEndDate; }
}
