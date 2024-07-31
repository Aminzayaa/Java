import java.util.ArrayList;

public class Student {
	private int id;
	private String name;
	private int age;
	private ArrayList<String>courses;
	
	public Student(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.courses = new ArrayList<>();
	}
	
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return this.age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<String> getCourses(){
		return this.courses;
	}
	public void setCourses(ArrayList<String> setCourses) {
		this.courses = setCourses ;
	}
	public void addCourses(String course) {
		this.courses.add(course);
	}
	public void removeCourse(String course) {
		this.courses.remove(course);
	}
}