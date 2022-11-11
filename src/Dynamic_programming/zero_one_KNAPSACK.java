package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class zero_one_KNAPSACK {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int value[] = new int[n];
		for(int i=0; i<n; i++){
			value[i] = sc.nextInt();
		}

		int weight[] =  new int[n];
		for(int i=0; i<n; i++){
			weight[i] = sc.nextInt();
		}
		int capacity = sc.nextInt();
		int ans = recursive(value , weight , capacity);
		System.out.println(ans);

		int ans1 = memoization(value , weight , capacity);
		System.out.println(ans1);
	}
	// recursive approach
	public static int recursive(int[] val, int[] weight, int capacity) {
		return knapsack_recursive(val , weight , capacity , 0 , val.length);
	}
	public static int knapsack_recursive(int v[] , int wt[] , int c ,int idx , int n){
		// base case
		if(n-1 == 0 || c == 0)
			return 0;
		if(v[n - 1] > c)
			return knapsack_recursive(v, wt, c, idx+1 , n-1);
		else {
			int incl = wt[n - 1] + knapsack_recursive(v, wt, c - v[n-1],idx+1 , n - 1);
			int excl = knapsack_recursive(v, wt, c, idx+1 , n - 1);
			return Math.max(incl, excl);
		}
	}

	// Top Down approach
	public static int memoization(int[] val, int[] weight, int capacity){
		int dp[][] = new int[val.length+1][weight.length+1];
		for(int row[]: dp)
			Arrays.fill(row , -1);
		return memoize_knapsack(val , weight , capacity , 0 , dp);
	}
	public static int memoize_knapsack(int[] val, int[] weight, int capacity, int i, int[][] dp) {
		if(i == val.length || capacity == 0)
			return 0;
		if(dp[i][capacity] != -1)
			return dp[i][capacity];
		dp[i][capacity] = Math.max(weight[i] + memoize_knapsack(val , weight , capacity-val[i] , i+1 , dp) ,
				memoize_knapsack(val , weight , capacity , i+1 , dp));
		return dp[i][capacity];
	}
}