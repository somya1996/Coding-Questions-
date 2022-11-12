package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class zwro_one_knapsack_no_limitation {
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
		int Weight = sc.nextInt();
		int ans = solve_recursive(Weight , weight , value);
		System.out.println(ans);

		int ans1 = memoization(Weight , weight , value);
		System.out.println(ans1);

		//int ans2 = tabulation(value , weight , capacity);
		//System.out.println(ans2);
	}
	public static int solve_recursive(int W , int wt[] , int val[]){
		return recursive(W , wt , val , val.length);
	}
	public static int recursive(int W , int wt[] , int val[] , int n){
		if(n == 0 || W == 0) return 0;
		if(wt[n-1] <= W){
			int incl = val[n-1]+recursive(W-wt[n-1] , wt , val , n );
			int excl = recursive(W , wt , val , n-1);
			return Math.max(incl , excl);
		}
		else{
			return recursive(W , wt , val , n-1);
		}
	}

	public static int memoization(int W , int wt[] , int val[]){
		int dp[][] = new int[val.length+1][W+1];
		for(int row[]: dp){
			Arrays.fill(row , -1);
		}
		return memoize(W , wt , val , val.length , dp);
	}
	public static int memoize(int W , int wt[] , int val[] , int n , int[][]dp){
		if(n == 0|| W == 0)
			return 0;
		if(dp[n][W] != -1)
			return dp[n][W];
		if(wt[n-1] <= W)
			dp[n][W] = Math.max(val[n-1]+memoize(W-wt[n-1] , wt , val , n , dp) , memoize(W , wt , val , n-1 , dp));
		else
			dp[n][W] = memoize(W , wt , val , n-1 , dp);
		return dp[n][W];
	}
}
