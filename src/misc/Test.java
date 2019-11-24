package misc;

import java.util.function.Predicate;

public class Test {

	int x = 888;

	public void m2() {
		int y = 999;
		Interf i = () -> {
			System.out.println("this.x = " + this.x);
		};

		i.m1();
	}

	public static void main(String[] args) {
		Test t = new Test();
		t.m2();
		Predicate<Integer> p = I -> I > 10;
		System.out.println(p.test(100));
		// System.out.println(p.test(""));
		System.out.println(p.test(1));
		for (int i = 0; i <= 15; i++) {
			if(p.test(i))
				System.out.println(i);
		}
		for (int i = 0; i <= 15; i++) {
			if(p.negate().test(i))
				System.out.println(i);
		}
	}

}
