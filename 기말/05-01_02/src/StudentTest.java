
class Student {

	private String studentID;
	private String name;
	
	Student(String ID, String name){
		studentID = ID;
		this.name = name;
	}
	
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean equals(Object obj) {
		// 형변환을 통해서 상위 클래스의 모든 객체들을 Student 클래스로 만들고 비교해줌
		
		Student obj1 = (Student) obj;
		String ID = obj1.studentID;
		
		if (ID == studentID)
			return true;
		else return false;
	}

}

public class StudentTest{
	public static void main(String[] args) {
		Student student1 = new Student("20230001", "홍길동");
		Student student2 = new Student("20230001", "이순신");
		
		System.out.println(student1.equals(student2));
	}
}