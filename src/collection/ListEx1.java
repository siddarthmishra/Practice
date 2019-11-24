package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class ListEx1 {

	public static void main(String[] args) {
		List<Object> l = new ArrayList<Object>();
		l.add(0, "0V");
		l.add(1, "1V");
		l.add(2, null);
		System.out.println(l);
		Collection<String> i = new ArrayList<String>();
		i.add("2V");
		i.add("3V");
		i.add("4V");
		i.add(null);
		l.addAll(3, i);
		System.out.println(l);
		System.out.println("l.remove(2) = " + l.remove(2));
		System.out.println(l);
		System.out.println("l.get(5) = " + l.get(5));
		System.out.println("l.set(2, '5V') = " + l.set(2, "5V")); // returns old value and set new value
		System.out.println(l);
		l.add("5V");
		System.out.println(l);
		System.out.println("indexOf(5V) = " + l.indexOf("5V"));
		System.out.println("lastIndexOf(5V) = " + l.lastIndexOf("5V"));
		System.out.println(l);
		ListIterator<Object> li = l.listIterator();
		while (li.hasNext()) {
			Object o = li.next();
			if(o == "1V")
				li.remove();
			if(o == "3V")
				li.add("10V");
			if(o == "4V")
				li.set("9V");
		}
		System.out.println(l);
	}
}
