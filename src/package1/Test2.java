package package1;

public class Test2 {

	public static void main(String[] args) {
		Test obj = new Test();
	}

}

class Test {
	public Test() {
		this(1);
		System.out.println("public");
	}

	private Test(int a) {
		this("test");
		System.out.println("private");
	}

	protected Test(String s) {
		System.out.println("protected");
	}
}
