package RECURSION.medium;

import java.util.Scanner;

public class Longest_Pallindromic_subsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		StringBuilder sb = new StringBuilder(a);
		sb.reverse();
		String b = sb.toString();
		int len = lps(a , b , a.length() , b.length()); // now thi is same as lcs
		System.out.println(len);
	}
	public static int lps(String a , String b , int n , int m){
		//base case
		if(n == 0 || m == 0 )
			return 0;

		if(a.charAt(n-1) == b.charAt(m-1)){
			return 1 + lps(a , b , n-1,m-1);
		}
		return Math.max(lps(a,b,n,m-1),lps(a,b,n-1,m));

	}
}
