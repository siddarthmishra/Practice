package com.hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class TimeConversion {

	/*
	 * Complete the timeConversion function below.
	 */
	static String timeConversion(String s) {
		/*
		 * Write your code here.
		 */
		String temp = s;
		String hrsStr = temp.substring(0, 2);
		String minSec = temp.substring(2);
		Integer hrsInt = Integer.parseInt(hrsStr.trim());
		System.out.println(hrsInt);
		if (temp.endsWith("PM")) {
			if(hrsInt != 12) hrsInt+=12;
			temp = hrsInt.toString().concat(minSec);
			temp = temp.replace("PM", "");
		}
		if (temp.endsWith("AM")) {
			if(hrsInt == 12) {
				temp = "00".concat(minSec);
			}
			temp = temp.replace("AM", "");
		}
		
		return temp;
	}

	private static final Scanner scan = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bw = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scan.nextLine();

		String result = timeConversion(s);

		// bw.write(result);
		// bw.newLine();

		// bw.close();
		System.out.println("result : " + result);
	}
}
