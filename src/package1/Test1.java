package package1;

import java.util.stream.Stream;

public class Test1 {

	public static void main(String[] args) {

		Stream.of(100000, 200000, 300000, 400000, 500000).filter(e -> e > 300000).peek(System.out::println).findFirst()
				.orElse(null);
		Test1 t1 = new Test1();
		t1.start();

		try {
			// System.exit(0);
		} finally {
			System.out.println(20 + 1.34f + "A" + "B");
		}

	}

	void start() {
		boolean b1 = false;
		boolean b2 = fix(b1);
		System.out.println(b1 + " " + b2);
		long[] a1 = { 3, 4, 5 };
		long[] a2 = fix(a1);
		System.out.print(a1[0] + a1[1] + a1[2] + " ");
		System.out.println(a2[0] + a2[1] + a2[2]);
	}

	boolean fix(boolean b1) {
		b1 = true;
		return b1;
	}

	long[] fix(long[] a3) {
		a3[1] = 7;
		return a3;
	}

}
