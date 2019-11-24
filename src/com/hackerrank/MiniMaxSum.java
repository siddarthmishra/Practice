package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MiniMaxSum {

	/*
	 * Complete the miniMaxSum function below.
	 */
	static void miniMaxSum(int[] arr) {
		/*
		 * Write your code here.
		 */
		long max = 0, min = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr) {
			list.add(i);
		}
		Collections.sort(list);
		
		System.out.println(list);

		for (int i = 0; i < arr.length - 1; i++) {
			min += list.get(i);
		}
		for (int i = arr.length - 1; i > 0; i--) {
			max += list.get(i);
		}
		System.out.println(min + " " + max);

	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = new int[5];

		String[] arrItems = scan.nextLine().split(" ");

		for (int arrItr = 0; arrItr < 5; arrItr++) {
			int arrItem = Integer.parseInt(arrItems[arrItr].trim());
			arr[arrItr] = arrItem;
		}

		miniMaxSum(arr);
	}
}
