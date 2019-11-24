package misc;

import java.util.HashSet;
import java.util.Set;

public class TestStudent {

	public static void main(String[] args) {
		Set<Student> l = new HashSet<Student>();
		populate(l);
		System.out.println(l);
		Student s1 = Student.getStudent();
		Student s2 = Student.getStudent();
		Student s3 = Student.getStudent();
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);
	}
	
	public static void populate(Set<Student> l) {
		l.add(new Student("A", "1"));
	}
}
