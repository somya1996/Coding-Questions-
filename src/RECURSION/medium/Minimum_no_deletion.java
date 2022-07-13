package RECURSION.medium;

import java.util.Scanner;
// same as longest Pallindromic subsequence
public class Minimum_no_deletion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String t = sb.toString();
		int len = deletion(s , t , s.length() , t.length());
		int deletion_of_string = s.length() - len;
		System.out.println(deletion_of_string);
	}
	// using recursion
	public static int deletion (String s , String t , int n , int m){
		if(n == 0 || m == 0)
			return 0;
		if(s.charAt(n-1) == t.charAt(m-1))
			return 1 + deletion(s , t , n-1 , m-1);

		return Math.max(deletion(s,t,n,m-1) , deletion(s,t,n-1,m));
	}
}
