package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exapmle1 {

	public static void main(String[] args) {

		List<Integer> l = new ArrayList<Integer>();
		l.add(0);
		l.add(10);
		l.add(20);
		l.add(5);
		l.add(15);
		l.add(25);
		System.out.println(l);
		System.out.println();

		List<Integer> l1 = l.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(l1);
		System.out.println();

		List<Integer> l2 = l.stream().map(i -> i * 2).collect(Collectors.toList());
		System.out.println(l2);
		System.out.println();

		List<String> ls = new ArrayList<String>();
		ls.add("Pavan");
		ls.add("Ravi Teja");
		ls.add("Chiranjeevi");
		ls.add("Venkatesh");
		ls.add("Nagarjuna");
		System.out.println(ls);
		System.out.println();

		List<String> ls1 = ls.stream().filter(s -> s.length() >= 9).collect(Collectors.toList());
		System.out.println(ls1);
		long count = ls.stream().filter(s -> s.length() >= 9).count();
		System.out.println("count of string length >= 9 is " + count);
		System.out.println();

		List<String> ls2 = ls.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(ls2);
		System.out.println();

		List<Integer> l3 = l.stream().sorted().collect(Collectors.toList());
		System.out.println(l3);

		List<Integer> l4 = l.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
		System.out.println(l4);
		System.out.println();

		List<String> ls3 = ls.stream().sorted().collect(Collectors.toList());
		System.out.println(ls3);

		List<String> ls4 = ls.stream().sorted((s1, s2) -> -s1.compareTo(s2)).collect(Collectors.toList());
		System.out.println(ls4);
		System.out.println();

		Optional<Integer> o = l.stream().min((a, b) -> a.compareTo(b));
		System.out.println("min : " + o.get());

		Integer max = l.stream().max((a, b) -> a.compareTo(b)).get();
		System.out.println("max : " + max);
		System.out.println();

		Consumer<String> c = System.out::println;
		ls.stream().forEach(c);
		System.out.println();

		// toArray() approach 1
		List<Integer> toArray1 = new ArrayList<Integer>();
		toArray1.add(0);
		toArray1.add(1);
		toArray1.add(2);
		toArray1.add(3);
		Object[] array1 = toArray1.stream().toArray();
		for (Object i : array1) {
			System.out.println(i);
		}
		System.out.println();

		// toArray() approach 2
		List<Integer> toArray2 = new ArrayList<Integer>();
		toArray2.add(4);
		toArray2.add(5);
		toArray2.add(6);
		toArray2.add(7);
		Integer[] array2 = toArray2.stream().toArray(Integer[]::new);
		for (Integer i : array2) {
			System.out.println(i);
		}
		System.out.println();

		// toArray() approach 3
		List<Integer> toArray3 = new ArrayList<Integer>();
		toArray3.add(8);
		toArray3.add(9);
		toArray3.add(10);
		toArray3.add(11);
		IntFunction<Integer[]> intfun = i -> new Integer[toArray3.size()];
		Integer[] array3 = toArray3.stream().toArray(intfun);
		for (Integer i : array3) {
			System.out.println(i);
		}
		System.out.println();

		Object[] objString = ls.stream().toArray();
		for (Object obj : objString) {
			System.out.println(obj);
		}
		System.out.println();

		String[] string = ls2.stream().toArray(String[]::new);
		for (String s : string) {
			System.out.println(s);
		}
		System.out.println();

		IntFunction<String[]> intfunString = i -> new String[ls3.size()];
		String[] stringArray = ls3.stream().toArray(intfunString);
		for (String i : stringArray) {
			System.out.println(i);
		}
		System.out.println();

		Supplier<Stream<Integer>> groupStreamSupplier = () -> Stream.of(99, 999, 9, 99999, 9999);
		groupStreamSupplier.get().forEach(System.out::println);
		System.out.println("count : " + groupStreamSupplier.get().count());
		System.out.println("min : " + groupStreamSupplier.get().min((a, b) -> a.compareTo(b)).get());
		System.out.println("max : " + groupStreamSupplier.get().max((a, b) -> a.compareTo(b)).get());
		System.out.println("sorted() : " + groupStreamSupplier.get().sorted().collect(Collectors.toList()));
		System.out.println("sorted(Comparator c) : "
				+ groupStreamSupplier.get().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList()));
		System.out.println();

		Double[] d = { 10.5, 10.1, 10.3, 10.4, 10.2 };
		Supplier<Stream<Double>> arrayStreamSupplier = () -> Stream.of(d);
		arrayStreamSupplier.get().forEach(i -> System.out.print(i + " "));
		System.out.println();
		System.out.println("count : " + arrayStreamSupplier.get().count());
		System.out.println("min : " + arrayStreamSupplier.get().min((a, b) -> a.compareTo(b)).get());
		System.out.println("max : " + arrayStreamSupplier.get().max((a, b) -> a.compareTo(b)).get());
		System.out.println("sorted() : " + arrayStreamSupplier.get().sorted().collect(Collectors.toList()));
		System.out.println("sorted(Comparator c) : "
				+ arrayStreamSupplier.get().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList()));
		System.out.println();
	}

}
