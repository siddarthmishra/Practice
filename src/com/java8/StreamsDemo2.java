package com.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo2 {

	public static void main(String[] args) throws Throwable {
		int ar[] = { 22, 77, 65, 23, 58, 88 };
		// out put =77,22,65,58,23,88

		List<String> st = Arrays.asList("this", "is", "siddarth mishra", "from", "Banglore");
		// List<String> st = Arrays.asList();
		// String s = st.stream().max((s1, s2) -> Integer.compare(s1.length(),
		// s2.length())).get();
		String maxLengthString = st.stream().max(Comparator.comparingInt(String::length)).orElseThrow();
		System.out.println(maxLengthString);

		List<Integer> numbers = Arrays.asList(5, 9, 11, 2, 8, 21, 1);
		// List<Integer> numbers = Arrays.asList();
		// int result =
		// numbers.stream().sorted(Comparator.reverseOrder()).limit(2).reduce((x, y) ->
		// x * y).orElse(0);
		int result = numbers.stream().min(Comparator.reverseOrder()).get();
		System.out.println(result);

		int[] array = { 2, 3, 5, 7, 11, 13, 17 };
		IntSummaryStatistics avg = Arrays.stream(array).summaryStatistics();
		System.out.println(avg);

		int arr[] = { 7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9 };
		Map<Integer, Long> map = Arrays.stream(arr).boxed()
				.collect(Collectors.toMap(Function.identity(), i -> 1L, (oldValue, newValue) -> oldValue + newValue));
		LinkedHashMap<Integer, Long> lhm = map.entrySet().stream()
				.sorted(Entry.<Integer, Long>comparingByValue(Comparator.reverseOrder())
						.thenComparing(Entry.<Integer, Long>comparingByKey(Comparator.reverseOrder())))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));
		System.out.println(lhm);
		long countOfDuplicate = lhm.entrySet().stream().filter(mapEntry -> mapEntry.getValue() >= 2).count();
		System.out.println("Count of Duplicate - " + countOfDuplicate);
		System.out.print("Results - ");
		lhm.entrySet().stream().limit(countOfDuplicate + 1)
				.forEach(mapEntry -> System.out.print(mapEntry.getKey() + " "));
		System.out.println();
		List<String> names = Arrays.asList("Bond", "James", "Einstein", "Alice", "Whitman", "Bob", "Binny", "Spider",
				"Lee", "Anderson");
		BinaryOperator<List<String>> merger = (oldValue, newValue) -> {
			oldValue.addAll(newValue);
			return oldValue;
		};
		Function<String, List<String>> valueFunction = string -> {
			List<String> l = new ArrayList<>();
			l.add(string);
			return l;
		};
		// max length
		// Supplier<TreeMap<Integer, List<String>>> supplier = () -> new
		// TreeMap<>(Comparator.reverseOrder());
		// min length
		Supplier<TreeMap<Integer, List<String>>> supplier = () -> new TreeMap<>();
		TreeMap<Integer, List<String>> treeMap = names.stream()
				.collect(Collectors.toMap(String::length, valueFunction, merger, supplier));
		System.out.println("Longest Strings in List :- " + treeMap.entrySet().stream().findFirst().get().getValue());

		String[] strArray1 = { "Sachin", "Dravid", "Ganguly", "Laxman", "Sehwag" };
		String[] strArray2 = { "Kumble", "Srinath", "Prasad", "Zaheer" };
		String[] strArray3 = { "Rohit", "Ashwin", "Kohli", "Dhoni" };
		// String[] mergedArray = Stream.of(strArray1, strArray2,
		// strArray3).flatMap(Arrays::stream).sorted().toArray(String[]::new);
		String[] mergedArray = Stream
				.concat(Arrays.stream(strArray1), Stream.concat(Arrays.stream(strArray2), Arrays.stream(strArray3)))
				.sorted().toArray(String[]::new);
		System.out.println(Arrays.toString(mergedArray));
		List<String> fruits = Arrays.asList("Apple", "Mango", "Grape", "Cherry", "Melon");
		List<String> veggies = Arrays.asList("Carrot", "Radish", "Lettuce", "Bean", "Gourd");
		System.out.println(Stream.concat(fruits.stream(), veggies.stream()).toList());
		// Stream 1
		Stream<Integer> stream1 = Stream.of(1, 2, 3);
		// Stream 2
		Stream<Integer> stream2 = Stream.of(1, 4, 5);
		// Stream 3
		Stream<Integer> stream3 = Stream.of(2, 6, 7);
		// Stream 4
		Stream<Integer> stream4 = Stream.of(3, 8, 9);
		// Merge multiple streams using Stream.of()
		Stream<Stream<Integer>> mergedStream = Stream.of(stream1, stream2, stream3, stream4);

		// flat the merged streams using flatMap() method
		Stream<Integer> resultStream = mergedStream.flatMap(Function.identity());
		resultStream.forEach(s -> System.out.print(s + " "));
		System.out.println();
		Set<String> hSetCompanies = new HashSet<String>();
		// adding elements to HashSet object
		hSetCompanies.add("LinkedIn");
		hSetCompanies.add("Amazon");
		hSetCompanies.add("Google");
		hSetCompanies.add("Apple");
		hSetCompanies.add("Facebook");
		hSetCompanies.add("Oracle");
		hSetCompanies.add("Microsoft");
		System.out.println("Companies - " + hSetCompanies.stream().sorted().toList());
		System.out.println("Companies Summary Statistics - " + hSetCompanies.stream().mapToInt(String::length).summaryStatistics());
		System.out.println("Max Length String - "
				+ hSetCompanies.stream().max((x, y) -> Integer.compare(x.length(), y.length())).orElseThrow());
		String str = "BeEnchReEsourceEs.NeEt";
		// character to be removed
		char ch = 'E';
		String resultRemovedString = str.chars().filter(i -> ch != (char) i).mapToObj(i -> String.valueOf((char) i))
				.collect(Collectors.joining(""));
		System.out.println(resultRemovedString);
		String duplicateUpper = "siddarth mishra";
		Set<String> duplicateStringSet = new HashSet<>();
		String resultDuplicateUpper = Arrays.stream(duplicateUpper.split(""))
				.map(s -> duplicateStringSet.add(s) ? s : s.toUpperCase()).collect(Collectors.joining(""));
		System.out.println(resultDuplicateUpper);
		// System.out.println(Arrays.toString(List.of("D", "B", "E", "A", "C").stream().sorted().toArray(String[]::new)));
		// System.out.println(Arrays.toString(List.of("D", "B", "E", "A", "C").stream().sorted().toArray(Demo3::m1)));
		System.out.println(Arrays.toString(List.of("D", "B", "E", "A", "C").stream().sorted().toArray(i -> new String[i])));
		IntStream intStream = IntStream.generate(() -> (new Random()).nextInt(25));
		System.out.println("IntStream.generate() - "
				+ intStream.limit(10).peek(i -> System.out.print(i + " ")).summaryStatistics());
		DoubleStream doubleStream = DoubleStream.generate(() -> Math.random() * 50);
		System.out.println("doubleStream.generate() - "
				+ doubleStream.limit(10).peek(i -> System.out.print(i + " ")).summaryStatistics());
		System.out.println();
		}

	private static String[] m1(int i) {
		return new String[i];
	}
}