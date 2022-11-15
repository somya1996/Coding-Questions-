package Dynamic_programming.KNAPSACK;

import java.util.Arrays;
import java.util.Scanner;

public class Tushars_Birthday {
	public static void main (String[]args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int eating_capacity[] = new int[n];
		for(int i=0; i<n; i++){
			eating_capacity[i] = sc.nextInt();
		}

		int[] filling_capacity = new int[n];
		for(int i=0; i<n; i++){
			filling_capacity[i] = sc.nextInt();
		}

		int[] cost = new int[n];
		for(int i=0; i<n; i++){
			cost[i] = sc.nextInt();
		}
		int ans = recursively(eating_capacity , filling_capacity , cost );
		System.out.println(ans);
	}
	public static int recursively(final int[] ec, final int[] fc, final int[] c) {
		int maxcap = 0;
		for(int i = 0; i<ec.length; i++)
			maxcap = Math.max(maxcap , ec[i]);
		int dp[][] = new int[ec.length+1][maxcap+1];
		for(int rows[] : dp){
			Arrays.fill(rows , -1);
		}
		int ans = 0;
		for(int i=0; i<ec.length; i++){
			ans += find(fc.length , ec[i] , dp , fc , c);
		}
		return ans;
	}
	/*
	public static int find(int[] fc , int[] c , int target , int n , int[][] dp){
		if(n == 0)
			return  Integer.MAX_VALUE;
		if(target == 0)
			return 0;
		if(dp[n][target] != -1)
			return dp[n][target];
		if(target <= fc[n-1])
			dp[n][target] = Math.min(c[n-1]+find(fc , c , target-fc[n-1] , n , dp) , find(fc , c , target , n-1 , dp));
		else
			dp[n][target] = find(fc , c , target , n-1 , dp);
		return dp[n][target];
	}*/
	private static int find(int i, int j, int[][] dp, int []fc, int[]c) {
		if (j == 0) {
			dp[i][j] = 0;
			return dp[i][j];
		}

		if (i == 0) {
			dp[i][j] = Integer.MAX_VALUE                                             ;
			return dp[i][j];
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		if (j >= fc[i - 1]) {
			dp[i][j] = Math.min(find(i - 1, j, dp, fc , c), c[i - 1] + find(i, j - fc[i - 1], dp, fc, c));
		} else {
			dp[i][j] = find(i - 1, j, dp, fc, c);
		}
		return dp[i][j];
	}
}
