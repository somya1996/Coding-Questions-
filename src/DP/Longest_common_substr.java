package DP;

import java.util.Scanner;

public class Longest_common_substr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Longest_common_substr lcs = new Longest_common_substr();

		int dp[][] = new int[s1.length()][s2.length()];
		int len3 = lcs.bottom_to_top(s1 , s2 , s1.length() , s2.length()); // using memoization
		System.out.println(len3);
	}

	private int bottom_to_top(String s1, String s2, int length, int length1) {
		int ans = 0;
		return ans;
	}
}
