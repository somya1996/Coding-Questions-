package DP;

import java.util.Scanner;

public class Longest_common_subseq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		// using DP  -  (Bottom Up)
		int n = s1.length();
		int m = s2.length();
		int dp[][] = new int[n + 1][m + 1];
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < m + 1; j++) {
				dp[i][j] = -1;
			}
		}

		int len2 = LCSubseq_memo(s1, s2, n, m, dp);
		System.out.println(len2);
	}

	// using memoization

	public static int LCSubseq_memo(String S1, String S2, int n, int m, int[][] dp) {
		//base case
		if (n == 0 || m == 0)
			return 0;

		if (dp[n][m] != -1)
			return dp[n][m];

		if (S1.charAt(n - 1) == S2.charAt(m - 1)) {
			//System.out.println(S1.charAt(n-1));
			dp[n][m] = 1 + LCSubseq_memo(S1, S2, n - 1, m - 1, dp);
			return dp[n][m];
		} else {
			dp[n][m] = Math.max(LCSubseq_memo(S1, S2, n, m - 1, dp), LCSubseq_memo(S1, S2, n - 1, m, dp));
			return dp[n][m];
		}

	}
}
