package RECURSION;

import java.util.Scanner;

public class SumOfNnumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//int sum = summing(n);
		//System.out.println(sum);

		summing(n,0);
	}
	// using functional recursion
	// TC = O(n)
	// SC = O(n)
	/*(public static int summing(int n){
		if(n == 0)
			return 0;
		return n + summing(n-1);
	}*/

	// using parameterized function
	public static int summing(int i , int sum) {
		if (i < 1) {
			System.out.println(sum);
			return 0;
		}
		return summing(i - 1, sum + i);
	}
}
