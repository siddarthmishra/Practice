package collection;

public class ArrayEx1 {

	public static void main(String[] args) {
		Student[] s = new Student[3];
		s[0] = new Student(1, "A");
		s[1] = new Student(2, "B");
		// s[2] = new Customer(1,"CA");

		Object[] obj = new Object[3];
		obj[0] = new Student(1, "A");
		obj[1] = new Student(2, "B");
		obj[2] = new Customer(1, "CA");
	}

}

class Student {
	int rollId;
	String name;

	public int getRollno() {
		return rollId;
	}

	public void setRollno(int rollno) {
		this.rollId = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student(int rollno, String name) {
		this.rollId = rollno;
		this.name = name;
	}

}

class Customer {
	int id;
	String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
}
