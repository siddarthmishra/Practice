package com.hackerrank;

import java.util.Scanner;

public class Kangaroo {

	static String kangaroo(int x1, int v1, int x2, int v2) {
		// Complete this function
		String yesNo = "";
		int jump = 0;
		boolean meet = false;
		if ((v1 < v2) || (v1 == v2)) {
			yesNo = "NO";
		} else {
			while (!meet) {
				x1 += v1;
				x2 += v2;
				jump++;
				System.out.println("JUMP : " + jump);
				System.out.println(x1 + "...." + x2);
				if (x1 == x2) {
					meet = true;
					yesNo = "YES";
				}
				else if((x1 > x2) && (v1 > v2)) {
					meet = true;
					yesNo = "NO";
				}
			}
		}

		return yesNo;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		String result = kangaroo(x1, v1, x2, v2);
		System.out.println(result);
		in.close();
	}
}
// 21 6 47 3 NO
// 0 3 4 2 YES
// 0 2 5 3 NO