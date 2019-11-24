package collection;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

public class ArrayListEx1 {

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		LinkedList ll = new LinkedList();
		System.out.println("is ArrayList  Serializable : " + (al instanceof Serializable));
		System.out.println("is ArrayList  Cloneable : " + (al instanceof Cloneable));
		System.out.println("is ArrayList  RandomAccess : " + (al instanceof RandomAccess));
		System.out.println();
		System.out.println("is LinkedList  Serializable : " + (ll instanceof Serializable));
		System.out.println("is LinkedList  Cloneable : " + (ll instanceof Cloneable));
		System.out.println("is LinkedList  RandomAccess : " + (ll instanceof RandomAccess));
		List l = Collections.synchronizedList(al);
		al.add(10);
		al.add(5);
		al.add(8);
		al.add(1);
		// al.add("a");
		System.out.println("Before sort = " + al);
		Collections.sort(al);
		System.out.println("After sort = " + al);
	}

}
