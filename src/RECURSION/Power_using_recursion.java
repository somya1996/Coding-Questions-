package RECURSION;

import java.util.Scanner;

public class Power_using_recursion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int n = sc.nextInt();
		int ans = power(a,n);
		System.out.println(ans);
	}
	public static int power(int a , int n){
		if(n==0)
			return 1;
		return a*power(a,n-1);
	}
}
