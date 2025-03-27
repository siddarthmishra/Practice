package com.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsByLengthAndSort {

	public static void main(String[] args) {
		List<String> words = Arrays.asList("java", "stream", "api", "example", "code", "test");
		Map<Integer, List<String>> groupWordsByLength = words.stream().collect(Collectors.groupingBy(String::length,
				Collectors.collectingAndThen(Collectors.toList(), list -> list.stream().sorted().toList())));
		System.out.println(groupWordsByLength);
	}
}
