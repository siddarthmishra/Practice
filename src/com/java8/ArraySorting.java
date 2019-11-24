package com.java8;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {
		int[] intArray = {22, 89, 1, 32, 19, 5};
		Arrays.sort(intArray);
		Arrays.stream(intArray).forEach(System.out::println);
		int[] intArray1 = {22, 89, 1, 32, 19, 5};
		Arrays.parallelSort(intArray1);
		System.out.println("============");
		Arrays.stream(intArray1).forEach(System.out::println);
		System.out.println("============");
		String[] stringArray = {"siddarth", "nikhita", "nikku", "sid", "chetan", "siddu", "nikki", "niks"};
		Arrays.parallelSort(stringArray, (a,b) -> -a.compareTo(b));
		Arrays.stream(stringArray).forEach(System.out::println);
		System.out.println("============");
		Integer[] integerArray = {22, 89, 1, 32, 19, 5};
		Arrays.parallelSort(integerArray, (a,b) -> -a.compareTo(b));
		Arrays.stream(integerArray).forEach(System.out::println);
		System.out.println("============");
		ArrayList<String> arrayList = new ArrayList<>();
		populateArrayList(arrayList);
		Object[] stringNames = arrayList.toArray();
		Arrays.sort(stringNames, (a,b) -> -a.toString().compareTo(b.toString()));
		Arrays.stream(stringNames).forEach(System.out::println);
		System.out.println("============");
	}
	public static void populateArrayList(ArrayList<String> arrayList) {
		for(int i = 65; i <= 70;i++) {
			Character c = (char)i;
			arrayList.add(c.toString());
		}
	}

}
