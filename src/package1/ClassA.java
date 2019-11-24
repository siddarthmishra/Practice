package package1;

public class ClassA {

	public static void main(String[] args) {
		ClassA a = new ClassA();
		a.count(3);
	}

	public void count(int i) {
		// System.out.println(i);
		count(++i);
	}

}
