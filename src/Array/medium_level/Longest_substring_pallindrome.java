package Array.medium_level;

import java.util.Scanner;

public class Longest_substring_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String s = longestPalindrome(str);
		System.out.println(s);
	}
	//Approach 1 and approach 2 is in interviewbit code
	// using dynamic programming
	public static String longestPalindrome(String A){
		String ans = "";
		int dp[][] = new int[A.length()][A.length()];
		for(int gap=0; gap<A.length(); gap++){
			for(int i=0 , j = gap; j<A.length(); i++,j++){
				if(gap == 0){
					dp[i][j] = 1;
				}
				else if(gap == 1){
					if(A.charAt(i) == A.charAt(j)){
						dp[i][j] = 1;
					}
					else{
						dp[i][j] = 0;
					}
				}
				else{
					if(A.charAt(i)==A.charAt(j) && dp[i+1][j-1]==1){
						dp[i][j] = 1;
					}
					else{
						dp[i][j] = 0;
					}
				}
			}
		}
		int start = -1 ;
		int len = -1;
		for(int i = 0; i<dp.length; i++){
			for(int j=i; j< dp[i].length; j++){
				if(dp[i][j] == 1 && j-i+1>len){
					len = j-i+1;
					start = i;
				}
			}
		}

		return A.substring(start,start+len);
	}
}
