package RECURSION.medium;

import java.util.Scanner;

public class Minimum_no_insertion_to_make_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String t = sb.toString();
		int len = insertion(s , t , s.length() , t.length());
		int insertion_of_string = s.length() - len;
		System.out.println(insertion_of_string);
	}
	public static int insertion (String s , String t , int n , int m){
		if(n == 0 || m == 0)
			return 0;
		if(s.charAt(n-1) == t.charAt(m-1))
			return 1 + insertion(s , t , n-1 , m-1);

		return Math.max(insertion(s,t,n,m-1) , insertion(s,t,n-1,m));
	}
}
