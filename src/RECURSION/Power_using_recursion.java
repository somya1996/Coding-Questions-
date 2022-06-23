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
	/*public static int power(int a , int n){
		if(n==0)
			return 1;
		return a*power(a,n-1);
	}*/
	public static int power(int a , int n){
		/*
		if(n == 0)
			return 1;
		else if(n % 2 == 0)
			return power(a*a,n/2);
		else{
			return  a*power(a*a , (n-1)/2);
		}
		*/

		if(n == 0)
			return 1;
		int res = power(a , n/2);
		int ans = res*res;
		if(n%2 == 1)
			ans = a*res*res;
		return ans;
	}
}
