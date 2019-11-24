package collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class LinkedHashSetEx1 {

	public static void main(String[] args) {
		HashSet<Object> hs = new LinkedHashSet<Object>();// insertion order preserved and duplicate not allowed
		System.out.println(hs.add("12"));
		System.out.println(hs.add("13"));
		System.out.println(hs.add("10"));
		System.out.println(hs.add(null));
		System.out.println(hs.add("5"));
		System.out.println(hs.add("10"));
		System.out.println(hs.add(null));
		System.out.println(hs);

	}

}
