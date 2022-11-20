package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Increasing_Subsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		// throw STACK OVERFLOW if we do recursion or use power set as it gives exponential
		int ans1 = length_of_LIS(arr);
		System.out.println(ans1);

		int ans2 = length_of_LIS_tabulation(arr);
		System.out.println(ans2);
	}
	public static int length_of_LIS(int[] arr){
		int[][] dp = new int[arr.length][arr.length+1];
		for(int rows[] : dp)
			Arrays.fill(rows , -1);
		return memoization(arr , 0 , -1 , arr.length , dp);
	}
	public static int memoization(int[] arr , int index , int prev_index ,  int n , int [][]dp){
		// base case
		if(index == n)
			return 0;
		if(dp[index][prev_index+1] != -1)
			return dp[index][prev_index+1];
		// recurrence
		int not_take = memoization(arr , index+1 , prev_index , n , dp); // if not picking that particular element
		int take = 0;
		// if this condition is true -- pick the element
		if(prev_index == -1 || arr[index] > arr[prev_index])
			take = 1 + memoization(arr , index+1 , index , n , dp);
		dp[index][prev_index+1] = Math.max(take , not_take);
		return dp[index][prev_index+1];
	}
	public static int length_of_LIS_tabulation(int[] arr){
		int n = arr.length;
		int[][] dp = new int[n+1][n+1];

		for(int index = n-1; index>=0; index--){
			for(int prev_index = index-1; prev_index>=-1; prev_index--){
				int not_take = 0+dp[index+1][prev_index+1];
				int take = 0;
				if(prev_index == -1 || arr[prev_index] > arr[index])
					take = 1 + dp[index+1][index+1];
				dp[index][prev_index+1] = Math.max(take , not_take);
			}
		}
		return dp[0][0];
	}
}