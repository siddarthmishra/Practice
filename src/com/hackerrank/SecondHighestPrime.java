package com.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.TreeSet;

public class SecondHighestPrime {
	// TCS HackerRank Challenge
	public static TreeSet<Integer> primeSet = new TreeSet<Integer>();

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			findPrime(num);
		}
		System.out.println(primeSet);
		Iterator<Integer> itr = primeSet.iterator();
		int k = 0;
		while(itr.hasNext()) {
			k++;
			if (k == 2) { // second highest prime
				System.out.println(itr.next());
				break;
			}
			itr.next();
		}
	}

	public static int findSecondLargestPrime(int[] values) {

		return 0;
	}

	public static void findPrime(int num) {
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				count++;
				if (count > 2)
					break;
			}
		}
		if (count == 2)
			primeSet.add(num);
	}
}

/*Test Input

6
1
3
17
33
44
43

*/

/* Answer

17

*/