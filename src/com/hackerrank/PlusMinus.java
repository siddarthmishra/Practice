package com.hackerrank;

import java.util.Scanner;

public class PlusMinus {

    /*
     * Complete the plusMinus function below.
     */
    static void plusMinus(int[] arr) {
        /*
         * Write your code here.
         */
        double positive = 0, negative = 0, zero = 0, size = arr.length;
        for(int i = 0; i < size; i++){
            if(arr[i] > 0)
                positive+=1;
            else if (arr[i] < 0)
                negative+=1;
            else
                zero+=1;
        }
        System.out.println((positive/size));
        System.out.println((negative/size));
        System.out.println((zero/size));

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine().trim());

        int[] arr = new int[n];

        String[] arrItems = scan.nextLine().split(" ");

        for (int arrItr = 0; arrItr < n; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr].trim());
            arr[arrItr] = arrItem;
        }

        plusMinus(arr);
    }
}

