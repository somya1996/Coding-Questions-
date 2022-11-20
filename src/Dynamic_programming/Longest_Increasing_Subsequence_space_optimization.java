package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_Subsequence_space_optimization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		// throw STACK OVERFLOW if we do recursion or use power set as it gives exponential
		int ans1 = longestIncreasingSubsequence(arr , n);
		System.out.println(ans1);
	}
	static int longestIncreasingSubsequence(int arr[], int n){

		int dp[]=new int[n];
		Arrays.fill(dp,1);

		for(int i=0; i<=n-1; i++){
			for(int prev_index = 0; prev_index <=i-1; prev_index ++){

				if(arr[prev_index]<arr[i]){
					dp[i] = Math.max(dp[i], 1 + dp[prev_index]);
				}
			}
		}

		int ans = -1;

		for(int i=0; i<=n-1; i++){
			ans = Math.max(ans, dp[i]);
		}

		return ans;
	}
}
