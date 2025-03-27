package com.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondMostRepeatedCharacters {

	public static void main(String[] args) {

		// final String input = "abc";
		// final String input = "aaaa";
		// final String input = "abbbccdee";
		// final String input = "success";
		// final String input = "programming";
		final String input = "swiss";
		/*
		 * =============================================================================
		 */
		// convert this map {c=2, s=3, e=1, u=1} to {3=[s], 2=[c], 1=[e, u]}
		Function<Map<String, Long>, Map<Long, Set<String>>> finisher1 = letterCountMap -> letterCountMap.entrySet()
				.stream().collect(Collectors.toMap(entry -> entry.getValue(), entry -> {
					Set<String> l = new TreeSet<>();
					l.add(entry.getKey());
					return l;
				}, (oldList, newList) -> {
					oldList.addAll(newList);
					return oldList;
				}, () -> new TreeMap<Long, Set<String>>(Comparator.reverseOrder())));
		/*
		 * =============================================================================
		 */
		Function<Map<Long, Set<String>>, Set<String>> finisher2 = countToSetOfLetters -> countToSetOfLetters.entrySet()
				.stream().skip(1).map(Entry::getValue).findFirst().orElseThrow(() -> new RuntimeException(
						"Not Found - Second Most Repeated Character for the given input : " + input));
		/*
		 * =============================================================================
		 */
		Set<String> secondMostRepeatedCharacters = Arrays.stream(input.toLowerCase().split(""))
				.collect(
						Collectors.collectingAndThen(
								Collectors.collectingAndThen(
										Collectors.groupingBy(Function.identity(), Collectors.counting()), finisher1),
								finisher2));
		/*
		 * =============================================================================
		 */
		System.out.println("Second Most Repeated Character(s) - "
				+ secondMostRepeatedCharacters.stream().collect(Collectors.joining(",")));

	}
}
