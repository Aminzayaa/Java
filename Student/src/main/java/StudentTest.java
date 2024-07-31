
public class StudentTest {

	public static void main(String[] args) {
		Student bat = new Student(1,"Bat",19);
		Student dorj = new Student(2,"Dorj", 18);
		
		System.out.println(bat.getAge());
		System.out.println(dorj.getName());
		bat.setAge(20);
		System.out.println(bat.getAge());
		dorj.setName("Dorjsuren");
		System.out.println(dorj.getName());
		bat.addCourses("Math");
		bat.addCourses("english");
		bat.addCourses("physics");
		for (String course : bat.getCourses()) {
			System.out.println(course);
		}
		System.out.println(bat.getCourses().size());
	
	dorj.setCourses(bat.getCourses());{
    for(String course:dorj.getCourses()) {
        System.out.println("dorj lesson " +course);
    }
  }
}
}
