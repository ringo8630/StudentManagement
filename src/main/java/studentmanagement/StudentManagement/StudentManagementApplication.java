package studentmanagement.StudentManagement;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentManagementApplication {

	private Map<String, String> studentMap = new HashMap<>();

	private String name = "Enami Kouji";
	private String age = "37";

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}

	// アプリ起動時に3名を初期登録
	public StudentManagementApplication() {
		studentMap.put("春美", "25");
		studentMap.put("太郎", "30");
		studentMap.put("花子", "28");
	}

	// 全員の情報を取得
	@GetMapping("/students")
	public Map<String, String> getAllStudents() {
		return studentMap;
	}

	// 特定の生徒情報を取得
	@GetMapping("/student/{name}")
	public String getStudent(@PathVariable String name) {
		if (studentMap.containsKey(name)) {
			return name + " は " + studentMap.get(name) + "歳です";
		} else {
			return "該当する生徒が見つかりません";
		}
	}

	// 新規生徒を登録
	@PostMapping("/addStudent")
	public String addStudent(@RequestParam String name, @RequestParam String age) {
		studentMap.put(name, age);
		return "登録完了: " + name + " (" + age + "歳)";
	}

	// 生徒情報を更新
	@PostMapping("/updateStudent")
	public String updateStudent(@RequestParam String name, @RequestParam String age) {
		if (studentMap.containsKey(name)) {
			studentMap.put(name, age);
			return "更新完了: " + name + " (" + age + "歳)";
		} else {
			return "該当する生徒が見つかりません";
		}
	}


	// 生徒を削除
	@DeleteMapping("/deleteStudent/{name}")
	public String deleteStudent(@PathVariable String name) {
		if (studentMap.containsKey(name)) {
			studentMap.remove(name);
			return name + " を削除しました";
		} else {
			return "該当する生徒が見つかりません";
		}
	}

}


//@GetMapping("/studentInfo")
//	public String getStudentInfo(){
//		return name + " " + age + "歳";
	//}

//	@PostMapping("/studentInfo")
//	public void setStudentInfo(String name, String age) {
//		this.name = name;
//		this.age = age;
//	}

	//@PostMapping("/studentName")
//	public void updateStudentName(String name){
	//	this.name = name;
//	}
//}