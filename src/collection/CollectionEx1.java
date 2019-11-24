package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionEx1 {

	public static void main(String[] args) {
		Collection<Object> s = new ArrayList<Object>();
		s.add("A");
		s.add("B");
		s.add("D");
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		Collection<String> i = new ArrayList<String>();
		i.add("1");
		i.add("2");
		i.add("retainAll");
		System.out.println("i = " + i);
		System.out.println("addAll : " + s.addAll(i));
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		System.out.println("addAll s: " + s.addAll(s));
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		System.out.println("contains D : " + s.contains("D"));
		System.out.println("contains 1 : " + s.contains("1"));
		System.out.println("containsAll s: " + s.containsAll(s));
		System.out.println("Remove D : " + s.remove("D")); // removes first D
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		System.out.println("Remove C : " + s.remove("C"));
		Collection<String> i1 = new ArrayList<String>();
		i1.add("8");
		i1.add("9");
		System.out.println("i1 = " + i1);
		System.out.println("addAll i1 : " + s.addAll(i1));
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		System.out.println("RemoveAll i1 : " + s.removeAll(i1));
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		System.out.print("toArray() = " + s.toArray() + " = ");
		System.out.println(s);
		System.out.println("isEmpty = " + s.isEmpty());
		Iterator<Object> itr = s.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " -> ");
		}
		System.out.println("end");
		System.out.println("retainAll(i) = " + s.retainAll(i));
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
		s.clear();
		System.out.println("void clear()");
		System.out.println("isEmpty = " + s.isEmpty());
		System.out.print("s = " + s.size() + " = ");
		System.out.println(s);
	}

}
