package com.hackerrank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class BirthdayCakeCandles {

	/*
	 * Complete the birthdayCakeCandles function below.
	 */
	static int birthdayCakeCandles(int n, int[] ar) {
		/*
		 * Write your code here.
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : ar) {
			list.add(i);
		}
		Collections.sort(list);
		System.out.println(list);
		int maxHeight = list.get(ar.length - 1);
		System.out.println("maxHeight : " + maxHeight);
		int countMax = 0;
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			int temp = itr.next();
			if (temp == maxHeight)
				countMax += 1;
		}

		return countMax;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int n = Integer.parseInt(scan.nextLine().trim());

		int[] ar = new int[n];

		String[] arItems = scan.nextLine().split(" ");

		for (int arItr = 0; arItr < n; arItr++) {
			int arItem = Integer.parseInt(arItems[arItr].trim());
			ar[arItr] = arItem;
		}

		int result = birthdayCakeCandles(n, ar);

		// bw.write(String.valueOf(result));
		// bw.newLine();

		// bw.close();
		System.out.println("result : " + result);
	}
}
