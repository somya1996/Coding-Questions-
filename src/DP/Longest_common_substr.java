package DP;

import java.util.Scanner;

public class Longest_common_substr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Longest_common_substr lcs = new Longest_common_substr();


		int len3 = lcs.top_to_bottom(s1 , s2 , s1.length() , s2.length() ); // using memoization
		System.out.println(len3);
	}

	private int top_to_bottom(String s1, String s2, int n, int m ) {
		int dp[][] = new int[n+1][m+1];
		int len = 0;
		for(int i= 0 ; i<n+1; i++){
			for(int j=0 ; j<m+1; j++){
				if( i == 0 || j == 0)
					dp[i][j] = 0;
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
					len = Math.max(len , dp[i][j]);
				}
				else
					dp[i][j] = 0;
			}
		}
		return len;
	}
}
