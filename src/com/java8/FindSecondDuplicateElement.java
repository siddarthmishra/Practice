package com.java8;

import java.util.Arrays;
import java.util.List;

public class FindSecondDuplicateElement {

	public static void main(String[] args) {
		// find the second duplicate element
		List<Integer> numbers = Arrays.asList(5, 3, 8, 3, 2, 1, 8, 7, 2);
		Integer result = numbers.stream().filter(i -> numbers.stream().filter(i1 -> i1 == i).count() > 1).skip(1)
				.findFirst().orElseThrow();
		System.out.println(result);
	}

}
