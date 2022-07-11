package RECURSION.medium;

import java.util.HashSet;
import java.util.Scanner;

public class Longest_common_substring_rec {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int len = common_substr( s1 , s2 , s1.length() , s2.length() , 0);
		System.out.println(len);
	}

	public static int common_substr(String s1 , String s2 , int n , int m ,int count){
		// base case
		if( n == 0 || m == 0 ){
			return count;
		}
		else if(s1.charAt(n-1) == s2.charAt(m-1)){
			count = common_substr(s1 , s2 , n-1 , m-1 , count+1);
		}

		count = Math.max(count , Math.max(common_substr(s1 , s2 , n-1 , m , 0) , common_substr(s1 , s2 , n , m-1 , 0)));
		return count;
	}
}
