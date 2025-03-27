package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FindAnagrams {

	public static void main(String[] args) {
		List<String> listOfWords = List.of("listen", "Below", "silent", "enlist", "rat", "tar", "god", "dog", "abc",
				"bac", "art", "rat", "elbow", "", "   ");
		List<Set<String>> anagrams = listOfWords.stream()
				.filter(word -> word != null && !word.isBlank() && !word.isEmpty())
				.collect(Collectors.collectingAndThen(
						Collectors.groupingBy(word -> Arrays.stream(word.toLowerCase().split("")).sorted()
								.collect(Collectors.joining("")), Collectors.toSet()),
						anagramMap -> anagramMap.values().stream()
								.filter(anagramList -> anagramList != null && anagramList.size() > 1).toList()));
		anagrams.forEach(System.out::println);
	}
}
