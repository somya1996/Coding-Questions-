package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class o_I_Knapsack_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] value = new int[n];
		for(int i=0; i<n; i++){
			value[i] = sc.nextInt();
		}

		int[] weight = new int[n];
		for(int i=0; i<n; i++){
			weight[i] = sc.nextInt();
		}

		int capacity = sc.nextInt();

		int ans = recursively(value , weight , capacity);
		System.out.println(ans);

		int ans1 = memoization(value , weight , capacity);
		System.out.println(ans1);
	}

	public static int recursively(int[] values, int[] weight, int capacity){
		return recusive(values , weight , capacity , values.length);
	}
	public static int recusive(int[] value , int[] weight , int capacity , int n){
		if(n == 0 || capacity == 0)
			return 0;
		if(capacity >= weight[n-1])
			return Math.max(value[n-1]+recusive(value , weight , capacity - weight[n-1] , n-1) ,
					recusive(value , weight , capacity , n-1));
		else
			return recusive(value , weight , capacity , n-1);
	}

	public static int memoization(int[] value , int[] weight , int capacity){
		int dp[][] = new int[value.length+1][capacity+1];
		for(int rows[]: dp)
			Arrays.fill(rows , -1);
		return  memoize(value , weight , capacity , value.length , dp);
	}
	public static int memoize(int[] value , int[] weight , int capacity , int n , int[][] dp){
		if(n == 0 || capacity == 0)
			return 0;
		if(dp[n][capacity] != -1)
			return dp[n][capacity];
		if(capacity >= weight[n-1])
			dp[n][capacity] = Math.max(value[n-1]+memoize(value , weight , capacity - weight[n-1] , n-1 , dp) ,
					memoize(value , weight , capacity , n-1 , dp));
		else
			dp[n][capacity] = memoize(value , weight , capacity , n-1 , dp);
		return dp[n][capacity];
	}
}
