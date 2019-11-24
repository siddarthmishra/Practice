package package1;

public class Test6 {

	public static void main(String[] args) {
		try {
			test();
		} catch (RuntimeException e) {
			System.out.print("end ");
		}
	}

	static void test() throws RuntimeException {
		try {
			System.out.print("test ");
			throw new RuntimeException();
		} catch (Exception e) {
			System.out.print("exception ");
		}
	}

}
