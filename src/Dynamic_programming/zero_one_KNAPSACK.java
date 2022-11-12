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
	// recursive approach (in reverse order)
	public static int recursive(int[] val, int[] weight, int capacity) {
		return knapsack_recursive(val , weight , capacity ,val.length);
	}
	public static int knapsack_recursive(int v[] , int wt[] , int c ,int n){
		// base case
		if(n == 0 || c == 0)
			return 0;
		if(v[n-1] > c)
			return knapsack_recursive(v, wt, c,n-1);
		else{ //v[idx]<= c if capacity is greater than value so we have 2 choice
			int incl = wt[n-1] + knapsack_recursive(v, wt, c - v[n-1], n-1);//include
			int excl = knapsack_recursive(v, wt, c,n-1);//exclude
			return Math.max(incl, excl);
		}
	}

	// TOP DOWN APPROACH
	public static int memoization(int[] val, int[] weight, int capacity){
		int dp[][] = new int[val.length+1][capacity+1];
		for(int row[]: dp)
			Arrays.fill(row , -1);
		return memoize_knapsack(val , weight , capacity , val.length , dp);
	}
	public static int memoize_knapsack(int[] val, int[] weight, int capacity, int n, int[][] dp) {
		if(n == 0 || capacity == 0)
			return 0;
		if(dp[n][capacity] != -1)
			return dp[n][capacity];
		if(val[n-1]<= capacity) {
			dp[n][capacity] = Math.max(weight[n - 1] + memoize_knapsack(val, weight, capacity - val[n - 1], n - 1, dp),
					memoize_knapsack(val, weight, capacity, n - 1, dp));
		}
		else //if(val[n-1]>capacity)
			dp[n][capacity] = memoize_knapsack(val, weight, capacity, n - 1, dp);
		return dp[n][capacity];
	}
}
