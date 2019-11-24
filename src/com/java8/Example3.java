package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example3 {

	public static void main(String[] args) {
		Supplier<Stream<String>> names4 = () -> Stream.of("Chetan", "Nikku", "Siddarth", "Nikki", "Nikhita");
		names4.get().parallel().filter(s -> s.startsWith("N")).findAny().ifPresent(System.out::println);
		names4.get().filter(s -> s.startsWith("N")).findAny().ifPresent(System.out::println);
		names4.get().parallel().filter(s -> s.startsWith("N")).findFirst().ifPresent(System.out::println);
		names4.get().filter(s -> s.startsWith("N")).findFirst().ifPresent(System.out::println);
		System.out.println("===================================================================================");
		// names4.get().parallel().filter(s ->
		// s.startsWith("N")).forEach(System.out::println);
		// System.out.println(names4.get().sorted().collect(Collectors.toList()));
		List<Integer> ints = IntStream.iterate(3, i -> i * 2).mapToObj(Integer::valueOf).limit(10)
				.collect(Collectors.toList());
		System.out.println(ints);
		List<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(1)).limit(10).collect(Collectors.toList());
		System.out.println(randomNumbers);
		System.out.println();
		Supplier<Stream<Integer>> num = () -> Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(num.get().collect(Collectors.filtering(i -> i % 2 != 0, Collectors.toList())));
		System.out.println(num.get().takeWhile(i -> i > 5).collect(Collectors.toList()));
		System.out.println("---------------WITH FLATMAP---------------");
		Stream<List<String>> flatMap = Stream.of(Arrays.asList("S","N"), Arrays.asList("T"), Arrays.asList("A","Z"));
		Stream<String> flatStream = flatMap.flatMap(l -> l.stream());
		flatStream.forEach(System.out::println);
		//flatStream.filter(s -> s.startsWith("N")).forEach(System.out::println);
		System.out.println("---------------WITHOUT FLATMAP---------------");
		flatMap = Stream.of(Arrays.asList("S","N"), Arrays.asList("T"), Arrays.asList("A","Z"));
		Function<List<String>, Object[]> function = l -> l.stream().toArray();
		Consumer<Object[]> action = o -> {
											for(Object s : o)
												//if(s.toString().startsWith("N"))
													System.out.println(s);
										};
		flatMap.map(function).forEach(action);
		System.out.println("------------------------------");
		
	}

}
