package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo1 {

	public static void main(String[] args) {
		String[] stringArray = new String[] { "c", "b", "a", "d", "e", "c", "e", "f" };
		System.out.println(Arrays.stream(stringArray).distinct().toList());
		String str1 = "java is a programming language";
		String result = Arrays.stream(str1.split(" ")).map(s -> Character.toUpperCase(s.charAt(0)) + s.substring(1))
				.collect(Collectors.joining(" ")); // make starting char of each word capital
		System.out.println(result);
		// output - avaj si a gnimmargorp egaugnal
		String reverseStr2 = Arrays.stream(str1.split(" "))
				.map(s -> Arrays.stream(s.split("")).reduce((x, y) -> y + x).get()).collect(Collectors.joining(" "));
		System.out.println("Reverse of each word in a string - " + reverseStr2);
		String reverseStr1 = Arrays.stream(str1.split(" ")).map(s -> new StringBuilder(s).reverse().toString())
				.collect(Collectors.joining(" "));
		System.out.println("Reverse of each word in a string - " + reverseStr1);
		System.out.println("Max Length String - "
				+ Arrays.stream(str1.split(" ")).max((x, y) -> Integer.compare(x.length(), y.length())).get());
		int[] intArray = new int[] { 4, 3, 9, 2, 6, 10, 0, 1, 5, 7, 8, 10 };
		int secondLargest = Arrays.stream(intArray).distinct().boxed().sorted(Comparator.reverseOrder())
				.mapToInt(Integer::intValue).skip(1).findFirst().getAsInt();
		System.out.println("Second Largest - " + secondLargest);
		System.out.println("Max - " + Arrays.stream(intArray).max().getAsInt());
		System.out.println("Min - " + Arrays.stream(intArray).min().getAsInt());
		System.out.println("Average - " + Arrays.stream(intArray).average().getAsDouble());
		Integer integer = Integer.valueOf(546783);
		System.out.println("Sum of digits of " + integer + " is - "
				+ Arrays.stream(integer.toString().split("")).mapToInt(Integer::parseInt).sum());
		System.out.println(Arrays.stream(str1.toLowerCase().split("")).filter(s -> !" ".equals(s))
				.collect(Collectors.toMap(Function.identity(), s -> 1, (oldValue, newValue) -> oldValue + newValue)));
		System.out.println(Arrays.stream(str1.toLowerCase().split("")).filter(s -> !" ".equals(s))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
		System.out.println("List in Ascending - " + Arrays.asList(stringArray).stream().sorted().toList());
		System.out.println("List in Descending - "
				+ Arrays.asList(stringArray).stream().sorted(Comparator.reverseOrder()).toList());
		List<String> listOfStrings = List.of("a", "s", "d", "f", "g");
		// List<String> listOfStrings = null;
		Optional<List<String>> optionalListOfStrings = Optional.ofNullable(listOfStrings);
		System.out.println(optionalListOfStrings.map(values -> values.stream().map(String::toUpperCase).toList())
				.orElseGet(() -> new ArrayList<String>()));
		// IntStream.rangeClosed(1, 10).forEach(i -> System.out.println((new
		// Random()).nextInt(i)));
		(new Random()).ints(10, 30, 100).forEach(System.out::println);
	}
}
