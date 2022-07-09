package Strings.Medium;

import java.util.Scanner;
import java.util.HashSet;
// 1) Using substring by printing all substring
// 2) Using recursion
// 3)  Using DP(memoization)

public class Longest_common_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Longest_common_pallindrome lcs = new Longest_common_pallindrome();
		/*
		int len1 = lcs.longestCommonSubstr(s1 , s2 , s1.length() , s2.length()); // using substring
		System.out.println(len1);
		*/
		int len2 = lcs.LCS(s1 , s2 , s1.length() , s2.length());  // using recursion
		System.out.println(len2);

	}
	/*
	int longestCommonSubstr(String S1, String S2, int n, int m){
		// one way  Time complexity : O(n^2 + m^2)   Space Complexity : O(n)

		int maxlen = 0;
		String ans = "";
		HashSet<String> hs = new HashSet<String>();
		for (int i = 0; i < S1.length(); i++) {
			String subStr="";

			for (int j = i; j < S1.length(); j++) {
				subStr += S1.charAt(j);
				hs.add(subStr);
			}
		}

		for(int i=0; i<S2.length(); i++){
			String substr = "";
			for(int j=i; j < S2.length(); j++){
				substr += S2.charAt(j);
				if(hs.contains(substr)){
					if(maxlen < substr.length()){
						maxlen = substr.length();
						ans = substr;
					}
				}
			}
		}
		System.out.println(ans);
		return maxlen;

	}*/

	// ******  using recursion   ******   TC - O(2^n)

	int LCS(String S1, String S2, int n, int m ){
		//base case
		if (n == 0 || m == 0)
			return 0;
		if(S1.charAt(n-1) == S2.charAt(m-1)) {
			//System.out.println(S1.charAt(n-1));
			return 1 + LCS(S1, S2, n - 1, m - 1);
		}
		else
			return Math.max(LCS(S1 , S2 , n , m-1) , LCS(S1 , S2 , n-1 , m));

	}

	// using memoization

	int lcs(String S1, String S2, int n, int m ){
		//base case
		if (n == 0 || m == 0)
			return 0;
		if(S1.charAt(n-1) == S2.charAt(m-1)) {
			//System.out.println(S1.charAt(n-1));
			return 1 + lcs(S1, S2, n - 1, m - 1);
		}
		else
			return Math.max(lcs(S1 , S2 , n , m-1) , lcs(S1 , S2 , n-1 , m));

	}
}
