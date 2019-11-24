package collection;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetEx1 {

	public static void main(String[] args) {
		SortedSet<Object> ss = new TreeSet<Object>();
		System.out.println(ss.add("12"));
		System.out.println(ss.add("13"));
		System.out.println(ss.add("10"));
		// System.out.println(hs.add(null));
		System.out.println(ss.add("5"));
		System.out.println(ss.add("10"));
		System.out.println(ss.add("25"));
		System.out.println(ss.add("7"));
		System.out.println(ss);
		System.out.println("first() : " + ss.first());
		System.out.println("last() : " + ss.last());
		System.out.println("headSet() : " + ss.headSet("25"));
		System.out.println("tailSet() : " + ss.tailSet("25"));
		System.out.println("subSet() : " + ss.subSet("13", "5"));
		System.out.println("comparator() : " + ss.comparator()); // null since default natural sorting order

	}

}