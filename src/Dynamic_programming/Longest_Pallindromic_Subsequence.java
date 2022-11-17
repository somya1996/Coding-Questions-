package Dynamic_programming;

import java.util.Scanner;

public class Longest_Pallindromic_Subsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = longestPalindromeSubseq(s);
		System.out.println(ans);

		int ans1 = tabulation(s);
		System.out.println(ans1);
	}
	public static int longestPalindromeSubseq(String s) {
		String rev = "";
		for(int i=s.length()-1; i>=0; i--){
			rev += s.charAt(i);
		}
		return recursive(s , rev , s.length() , rev.length());
	}
	public static int recursive(String s , String r , int n , int m){
		if(n == 0 || m == 0)
			return 0;
		if(s.charAt(n-1) == r.charAt(m-1))
			return 1 + recursive(s , r , n-1 , m-1);
		else
			return Math.max(recursive(s , r , n-1 , m) , recursive(s , r , n , m-1));
	}

	public static int tabulation(String s ){
		int n = s.length();
		int dp[][] = new int[n][n];
		for(int i=0; i<n; i++){
			dp[i][i] = 1;
		}
		for(int len = 2; len <= n; len++){
			for(int i=0; i<n - len + 1; i++){
				int j = i+len-1;
				if((s.charAt(i) == s.charAt(j)) && len == 2)
					dp[i][j] = 2;
				else if(s.charAt(i) == s.charAt(j))
					dp[i][j] = dp[i+1][j-1]+2;
				else
					dp[i][j] = Math.max(dp[i][j-1] , dp[i+1][j]);
			}
		}
		return dp[0][n-1];
	}
}
