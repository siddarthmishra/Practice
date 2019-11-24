package com.number.pattern;
import java.io.BufferedReader;
import java.io.InputStreamReader;


// If N = 4
// Output should be
// 1 3*2 4*5*6 10*9*8*7
// If N = 3
// Output should be
// 1 3*2 4*5*6

class AmcatNumberPattern1 
{
	public static void main(String args[] ) throws Exception 
	{
		// Write your code here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int count = 0;
		for(int i = 1; i <= N; i++){
		    StringBuffer sb = new StringBuffer();
		    for(int j = 1; j <= i; j++){
		        count++;
		        //if(i % 2 == 1) {
		        	sb.append(count);
			        if(j < i){
			            sb.append("*");
			        }
		        //} else
		        	;
		    }
		        System.out.print(sb.toString());
		}
	}
}