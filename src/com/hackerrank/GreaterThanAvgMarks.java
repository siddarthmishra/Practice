package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GreaterThanAvgMarks {
	// TCS HackerRank Challenge
	public static double total, avg;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Student[] student = new Student[N];
		for (int i = 0; i < N; i++) {
			int id = Integer.parseInt(br.readLine());
			String name = br.readLine();
			double marks = Double.parseDouble(br.readLine());
			total = total + marks;
			Student s = new Student(id, name, marks);
			student[i] = s;
		}
		avg = total/N;
		studentsWithMarksMoreThanAvg(student);
	}
	
	public static Student[] studentsWithMarksMoreThanAvg(Student[] students) {
		for (Student s : students) {
			if(s.getMarks() > avg) {
				System.out.println(s);
			}
		}
		return null;
	}
}

class Student {
	private int id;
	private String name;
	private double marks;

	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

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

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return id + " " + name + " " + marks;
	}
}

/*Test Input

4
1
aaa
40.0
2
bbb
10.0
3
ccc
50.0
4
ddd
20.0

*/

/* Answer

1 aaa 40.0
3 ccc 50.0

*/