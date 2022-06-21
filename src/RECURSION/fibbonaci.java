package RECURSION;

import java.util.Scanner;

public class fibbonaci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = fib(n);
		System.out.println(ans);
	}
	public static int fib(int n){
		if(n == 0 || n == 1){
			return n;
		}
		return fib(n-1)+fib(n-2);

		// recursion tree
		/*
						 f(4)   Each node calling 2 sub recursions 2
						/    \
					f(3)      f(2)
					/  \	  /  \
				f(2)  f(1)	f(1)  f(0)
				/ \
			f(1)  f(0)
			so each node calling 2 recursion so for n node 2*2*2*2*...n times
			Time Complexity - (2^n)
			Space Complexity - O(n)
		*/
	}
}
