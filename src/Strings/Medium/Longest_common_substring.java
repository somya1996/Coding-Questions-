package Strings.Medium;

import java.util.Scanner;
import java.util.HashSet;
// 1) Using substring by printing all substring
// 2) Using recursion
// 3)  Using DP(memoization)

public class Longest_common_substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Longest_common_substring lcs = new Longest_common_substring();

		int len1 = lcs.longestCommonSubstr(s1 , s2 , s1.length() , s2.length()); // using substring
		System.out.println(len1);

	}

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

	}

}
