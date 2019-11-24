package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class DiagonalDifference {

	/*
	 * Complete the diagonalDifference function below.
	 */
	static int diagonalDifference(int[][] a) {
		/*
		 * Write your code here.
		 */

		int n = a.length;
		int primary = 0, secondary = 0;
		for (int i = 0; i < n; i++) {
			primary += a[i][i];
			secondary += a[i][n - i - 1];
		}
		return Math.abs(primary - secondary);
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		System.out.println("Enter size of array : ");
		int n = Integer.parseInt(scan.nextLine().trim());

		int[][] a = new int[n][n];

		System.out.println("Enter array values : ");
		for (int aRowItr = 0; aRowItr < n; aRowItr++) {
			String[] aRowItems = scan.nextLine().split(" ");

			for (int aColumnItr = 0; aColumnItr < n; aColumnItr++) {
				int aItem = Integer.parseInt(aRowItems[aColumnItr].trim());
				a[aRowItr][aColumnItr] = aItem;
			}
		}
		System.out.println("END");

		int result = diagonalDifference(a);

		// bw.write(String.valueOf(result));
		// bw.newLine();

		// bw.close();
		System.out.println("Result : " + result);
	}

}
