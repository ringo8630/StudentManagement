package studentmanagement.StudentManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
  private Long id;
  private String Name;
  private String KanaName;
  private String nickname;
  private String email;
  private String area;
  private int age;
  private String sex;

//  public Student(Long id, String fullName, String furigana, String nickname,
//      String email, String region, int age, String gender) {
//    this.id = id;
//    this.fullName = fullName;
//    this.furigana = furigana;
//    this.nickname = nickname;
//    this.email = email;
//    this.region = region;
//    this.age = age;
//    this.gender = gender;
//  }
//
//  public Long getId() { return id; }
//  public String getFullName() { return fullName; }
//  public String getFurigana() { return furigana; }
//  public String getNickname() { return nickname; }
//  public String getEmail() { return email; }
//  public String getRegion() { return region; }
//  public int getAge() { return age; }
//  public String getGender() { return gender; }
}
