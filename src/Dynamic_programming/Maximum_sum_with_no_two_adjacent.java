package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Maximum_sum_with_no_two_adjacent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = FindMaxSum_recursively(arr , n);
		System.out.println(ans);

		int ans1 = top_down(arr , n);
		System.out.println(ans1);

		int ans2 = bottom_up(arr , n);
		System.out.println(ans2);
	}
	public static int FindMaxSum_recursively(int arr[], int n)
	{
		int ans = recursively(arr , n , 0);
		return ans;
	}
	public static int recursively(int[] arr , int n , int index){
		if(index >= n)
			return 0;
		int incl = arr[index] + recursively(arr , n , index+2);
		int excl = recursively(arr , n , index+1);
		return Math.max(incl , excl);
	}

	public static int top_down(int[] arr , int n){
		int dp[] = new int[n];
		Arrays.fill(dp , -1);
		return solve_top_down(arr , 0 , dp);
	}
	public static int solve_top_down(int[] arr , int index , int[]dp){
		if(index>=arr.length)
			return 0;
		if(dp[index] != -1)
			return dp[index];
		int incl = arr[index] + solve_top_down(arr , index+2 , dp);
		int excl = solve_top_down(arr , index+1, dp);
		dp[index] = Math.max(incl , excl);
		return dp[index];
	}

	public static int bottom_up(int[] arr , int n){
		int dp[] = new int[n];
		dp[0] = 0;
		for(int i=1; i<n; i++){
			int incl = dp[i-2] + arr[i];
			int excl = dp[i-1];
			dp[i] = Math.max(incl , excl);
		}
		return dp[n-1];
	}
}
