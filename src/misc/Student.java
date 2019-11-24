package misc;

public class Student {
	
	private String name;
	private String rollno;
	private static Student student = null;
	
	private Student() {}
	
	public Student(String name, String rollno){
		this.name = name;
		this.rollno = rollno;
	}
	
	public static Student getStudent() {
		if(student == null)
			student = new Student();
		return student;
	}

	public String getName() {
		return name;
	}

	public String getRollno() {
		return rollno;
	}

	
	  @Override public String toString() { return "Student [name=" + name +
	  ", rollno=" + rollno + "]"; }
	 
}
