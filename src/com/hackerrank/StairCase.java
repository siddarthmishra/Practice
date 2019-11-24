package com.hackerrank;

import java.util.Scanner;

public class StairCase {

    /*
     * Complete the staircase function below.
     */
    static void staircase(int n) {
        /*
         * Write your code here.
         */
        for(int i = 1; i <= n; i++){
        	int j = n;
            while(j > i) {
            	System.out.print(" ");
            	j--;
            }
            while(j > 0) {
            	System.out.print("#");
            	j--;
            }           
            System.out.println();
        }
        
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
    	System.out.println("Enter number : ");
        int n = Integer.parseInt(scan.nextLine().trim());

        staircase(n);
    }
}

