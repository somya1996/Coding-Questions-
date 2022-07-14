package DP;

import java.util.Scanner;

public class Minimum_insertion_to_make_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len1 = insertion(s);
		int dos = s.length()-len1;
		System.out.println(dos);

		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		String t = sb.toString();
		int len = lcp_insertion(s , t , s.length() , t.length());
		//System.out.println(len);
		int deletion_of_character = s.length() - len;
		System.out.println(deletion_of_character);
	}

	// this is using longest common subseq
	private static int lcp_insertion( String X , String Y , int m , int n){
		int L[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					L[i][j] = 0;
				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					L[i][j] = L[i - 1][j - 1] + 1;
				}
				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];
	}
	// this is using longest Pallindromic subseq
	public static int insertion(String s){
		int dp[][] = new int[s.length()][s.length()];
		int n = s.length();
		for(int i=0; i<n; i++) //// for string len = 1
			dp[i][i] = 1;

		for(int len = 2; len <= n; len++){  // length of string // O (k)
			for(int i=0; i<=n-len ; i++){  //O(n)
				int j = i+len-1;
				if(s.charAt(i) == s.charAt(j) && len == 2)
					dp[i][j] = 2;
				else if(s.charAt(i) == s.charAt(j)){
					dp[i][j] = dp[i+1][j-1] + 2;
				}
				else
					dp[i][j] = Math.max(dp[i+1][j] , dp[i][j-1]);
			}
		}

		return dp[0][n-1];
	}
}
