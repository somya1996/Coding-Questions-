package Dynamic_programming;

import java.util.Scanner;

public class Flip_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = recursively_solve(arr);
		System.out.println(ans);
	}
	public static int recursively_solve(final int[] A){
		return recursive(A , A.length , 0 , 0);
	}
	public static int recursive(int A[] , int n , int sum , int flip){
		if(n == 0) {
			return Integer.MAX_VALUE;
		}
		return Math.min(recursive(A , n-1 , sum+(-A[n-1]) , flip++) , recursive(A , n-1 , sum + A[n-1] , flip));
	}
	public static int memoization(int arr[] , int n , int sum , int[][]dp){
		if (sum == 0) {
			return 0;
		}
		if (n == -1) {
			return arr.length + 1; //Flips cannot be more than arr.length
		}
		if (dp[n][sum] != -1) {
			return dp[n][sum];
		}
		int ans = 0;
		if (sum - arr[n] >= 0) {
			ans = Math.min(memoization(arr, n - 1, sum - arr[n] , dp) + 1, memoization(arr, n - 1, sum , dp));
		} else {
			ans = memoization(arr, n - 1, sum , dp);
		}
		dp[n][sum] = ans;
		return dp[n][sum];
	}
}
