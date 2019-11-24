package com.number.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Line 1 size N of array
// Line 2 N elements of array separated by space

//E.g : N = 5
//4 1 3 2 7
// O/P : 5 6

public class MissingNumber {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int[] arr = new int[N];
		String[] s_arr = br.readLine().split(" ");
		for(int i = 0; i < s_arr.length; i++) {
			arr[i] = Integer.parseInt(s_arr[i].trim());
		}
		
		br.close();
	}

}
