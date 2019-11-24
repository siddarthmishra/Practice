package com.java8;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.IntSummaryStatistics;
import java.util.LinkedList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;

public class CollectorsExample {

	public static void main(String[] args) {
		List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
		List<String> resultList = givenList.stream().collect(toList());
		System.out.println(resultList);
		System.out.println(resultList.getClass());
		Set<String> resultSet = givenList.stream().collect(toSet());
		System.out.println(resultSet);
		System.out.println(resultSet.getClass());
		List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");
		resultSet = listWithDuplicates.stream().collect(toSet());
		System.out.println(resultSet);
		Assertions.assertThat(resultSet).hasSize(4);
		List<String> resultLinkedList = givenList.stream().collect(toCollection(LinkedList::new));
		System.out.println(resultLinkedList);
		System.out.println(resultLinkedList.getClass());
		Map<String, Integer> resultMap = givenList.stream().collect(toMap(Function.identity(), String::length));
		System.out.println(resultMap);
		System.out.println(resultMap.getClass());
		try {
			resultMap = listWithDuplicates.stream().collect(toMap(Function.identity(), String::length));
		} catch (Exception e) {
			System.out.println(e);
		}
		resultMap = listWithDuplicates.stream()
				.collect(Collectors.toMap(Function.identity(), String::length, (item, identicalItem) -> item));
		System.out.println(resultMap);
		resultList = givenList.stream().collect(Collectors.collectingAndThen(toList(), Collections::unmodifiableList));
		System.out.println(resultList);
		Function<List<String>, List<String>> f = (l) -> l.parallelStream().filter(s -> s.length() > 6)
				.collect(Collectors.toList());
		List<String> list1 = Arrays.asList("Siddarth", "Nikku", "Nikki", "Sid", "Nikhita", "Chetan");
		List<String> resultList1 = list1.stream().collect(Collectors.collectingAndThen(toList(), f));
		System.out.println(resultList1);
		String resultString = givenList.stream().collect(Collectors.joining());
		System.out.println(resultString);
		resultString = givenList.stream().collect(Collectors.joining(" "));
		System.out.println(resultString);
		resultString = givenList.stream().collect(Collectors.joining(" ", "PRE-", "-POST"));
		System.out.println(resultString);
		String resultString1 = resultList1.stream().collect(Collectors.joining(" WEDS "));
		System.out.println(resultString1);
		Long counting = givenList.stream().collect(Collectors.counting());
		System.out.println(counting);
		DoubleSummaryStatistics resultSummary = list1.stream().collect(Collectors.summarizingDouble(String::length));
		System.out.println(resultSummary);
		IntSummaryStatistics resultSummary1 = list1.stream().collect(Collectors.summarizingInt(String::length));
		System.out.println(resultSummary1);
		LongSummaryStatistics resultSummary2 = list1.stream().collect(Collectors.summarizingLong(String::length));
		System.out.println(resultSummary2);
		Double averaging = list1.stream().collect(Collectors.averagingDouble(String::length));
		System.out.println(averaging);
		averaging = list1.stream().collect(Collectors.averagingInt(String::length));
		System.out.println(averaging);
		averaging = list1.stream().collect(Collectors.averagingLong(String::length));
		System.out.println(averaging);
		Double summingDouble = list1.stream().collect(Collectors.summingDouble(String::length));
		System.out.println(summingDouble);
		Long summingLong = list1.stream().collect(Collectors.summingLong(String::length));
		System.out.println(summingLong);
		Integer summingInt = list1.stream().collect(Collectors.summingInt(String::length));
		System.out.println(summingInt);
		List<String> listMinMax = Arrays.asList("N", "A", "C", "X", "S", "D");
		Optional<String> maxBy = listMinMax.stream().collect(Collectors.maxBy(Comparator.naturalOrder()));
		maxBy.ifPresent(System.out::println);
		Optional<String> minBy = listMinMax.stream().collect(Collectors.minBy(Comparator.naturalOrder()));
		minBy.ifPresent(System.out::println);
		Map<Boolean, List<String>> partitioningBy1 = list1.stream()
				.collect(Collectors.partitioningBy(s -> s.length() > 6));
		System.out.println(partitioningBy1);
		Map<Boolean, Long> partitioningBy2 = list1.stream()
				.collect(Collectors.partitioningBy(s -> s.length() > 6, Collectors.counting()));
		System.out.println(partitioningBy2);

		Map<Integer, Set<String>> groupingBy = list1.stream().collect(Collectors.groupingBy(String::length, toSet()));
		System.out.println(groupingBy);
		groupingBy = givenList.stream().collect(Collectors.groupingBy(String::length, toSet()));
		System.out.println(groupingBy);
		groupingBy = listWithDuplicates.stream().collect(Collectors.groupingBy(String::length, toSet()));
		System.out.println(groupingBy);
		List<String> items = Arrays.asList("apple", "apple", "banana", "apple", "orange", "banana", "papaya");
		Map<String, Long> resultItems = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(resultItems);
		resultList1 = list1.stream().collect(Collectors.filtering(s -> s.length() > 6, Collectors.toList()));
		System.out.println(resultList1);
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		List<Object> intListResult = intList.stream()
				.collect(Collectors.mapping(i -> Math.pow(i, i), Collectors.toList()));
		System.out.println(intListResult);
		Stream<List<String>> flatMap = Stream.of(Arrays.asList("S", "N"), Arrays.asList("T"), Arrays.asList("A", "Z"));
		Function<List<String>, Stream<String>> f1 = l -> l.stream();
		List<String> flatStream = flatMap.collect(Collectors.flatMapping(f1, Collectors.toList()));
		System.out.println(flatStream);
		intList.stream().collect(Collectors.reducing((a, b) -> a + b)).ifPresent(System.out::println);
		System.out.println(intList.stream().collect(Collectors.reducing(1, (a, b) -> a * b)));
		System.out.println(intList.stream().collect(Collectors.reducing(1, i -> i + 2, (a, b) -> a * b)));
		System.out.println(list1.stream().collect(Collectors.reducing("START -> ",
				s -> s.length() > 6 ? s.toUpperCase() : s.toLowerCase(), (a, b) -> a + " " + b)));
	}

}
