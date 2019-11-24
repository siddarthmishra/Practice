package misc;

import java.util.ArrayList;
import java.util.Collection;

public class Test1 {

	public static void main(String[] args) {
		int x = 10, y = 20;
		x = ~-~y;
		System.out.println("x = " + x);
		Test1 test1 = null;
		test1.println();
		System.out.println(new Test1().getString());
		Integer[] ia = new Integer[100];
		Collection<Number> cn = new ArrayList<Number>();
		fromArrayToCollection(ia, cn);
	}

	public static void println() {
		System.out.println("println");
	}

	public String getString() {
		return "getString";
	}

	public static <T> void fromArrayToCollection(T[] a, Collection<T> c) {
		for (T o : a) {
			c.add(o);
		}
	}

}
