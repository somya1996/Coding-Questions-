package DP;

import java.util.Scanner;
// Time complexity - O(n^2)
// Space complexity - O(n^2)
public class Longest_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = longest_Pall(s);
		System.out.println(ans);
	}

	private static String longest_Pall(String s) {
		int dp[][] = new int[s.length()][s.length()];
		int n = s.length();
		int maxlen = 1;
		int start = 0;


		for(int i=0; i<n; i++) //// for string len = 1
			dp[i][i] = 1;

		for(int i=0; i<n-1; i++){ // for string len = 2
			if(s.charAt(i) == s.charAt(i+1))
				dp[i][i+1] = 1;
				start = i;
				maxlen = 2;

		}

		for(int k = 3; k <= n; k++){  // length of string // O (k)
			for(int i=0; i<=n-k; i++){  //O(n)
				int j = i+k-1;
				if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==1){
					if(k > maxlen) {
						start = i;
						maxlen = k;
					}
				}
			}
		}

		return s.substring(start , start+maxlen);  //O(n)
	}

}
