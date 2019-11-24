package com.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Example2 {

	public static void main(String[] args) {
		IntStream is = IntStream.of(1, 2, 3, 4, 5);
		LongStream ls = LongStream.of(6, 7, 8, 9, 10);
		DoubleStream ds = DoubleStream.of(1.0, 2.0, 3.0, 4.0, 5.0);
		is.forEach(i -> System.out.print(i + " "));
		System.out.println();
		ds.forEach(i -> System.out.print(i + " "));
		System.out.println();
		ls.forEach(i -> System.out.print(i + " "));
		System.out.println();

		IntStream is2 = "abc".chars();
		is2.forEach(System.out::println);

		Stream<Integer> numbers = Stream.of(1, 2, 3, 4, 5);

		Optional<Integer> intOptional = numbers.reduce((i, j) -> i * j);
		if (intOptional.isPresent())
			System.out.println("Multiplication = " + intOptional.get()); // 120
		numbers = Stream.of(1, 2, 3, 4, 5);
		Integer integer = numbers.reduce(1, (i, j) -> i * j);
		System.out.println("Multiplication = " + integer); // 120
		numbers = Stream.of(1, 2, 3, 4, 5);
		integer = numbers.reduce(0, Integer::sum);
		System.out.println("Addition = " + integer); // 120
		// Scanner sc = new Scanner(System.in);
		// System.out.println("Enter startInclusive");
		int startInclusive = 0;
		// System.out.println("Enter End");
		int end = 5;
		IntStream is3 = IntStream.range(startInclusive, end);
		is3.forEach(i -> System.out.print(i + " "));
		System.out.println();
		IntStream is4 = IntStream.rangeClosed(startInclusive, end);
		is4.forEach(i -> System.out.print(i + " "));
		System.out.println();
		int number = -109;
		System.out.println("isPrime : " + isPrime1(number));
		System.out.println("isPrime : " + isPrime2(number));
		System.out.println("isPrime : " + isPrime3(number));

		// BOXED STREAM
		// List<Integer> ints = IntStream.of(1,2,3,4,5).collect(Collectors.toList());
		List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());
		System.out.println(ints);
		List<Long> longs = LongStream.of(1l, 2l, 3l, 4l, 5l).boxed().collect(Collectors.toList());
		System.out.println(longs);
		List<Double> doubles = DoubleStream.of(1d, 2d, 3d, 4d, 5d).boxed().collect(Collectors.toList());
		System.out.println(doubles);
		List<Integer> l = new ArrayList<>();
		for (int i = 1; i <= 20; i++)
			l.add(i);
		List<Integer> limit = l.stream().limit(8).collect(Collectors.toList());
		System.out.println(limit);
		List<Integer> skip = l.stream().skip(10).collect(Collectors.toList());
		System.out.println(skip);
	}

	// Declarative approach
	private static boolean isPrime1(int number) {
		return number > 1 && IntStream.range(2, number).noneMatch(index -> number % index == 0);
	}

	private static boolean isPrime2(int number) {
		return number > 1 && IntStream.range(2, number).allMatch(index -> number % index != 0);
	}

	private static boolean isPrime3(int number) {
		return IntStream.rangeClosed(1, number).filter(i -> number % i == 0).count() == 2;
	}
}
