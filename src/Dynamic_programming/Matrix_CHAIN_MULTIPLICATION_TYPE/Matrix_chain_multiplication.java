package Dynamic_programming.Matrix_CHAIN_MULTIPLICATION_TYPE;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Matrix_chain_multiplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();

		int ans = solve(arr);
		System.out.println(ans);

		int ans1 = memoization(arr);
		System.out.println(ans1);
	}
	public static int solve(int[] A) {
		return recursive(A , 1 , A.length-1);
	}
	public static int recursive(int[] A , int i , int j){
		// base case
		if(i >= j)
			return 0;
		int min_ans = Integer.MAX_VALUE;
		for(int k = i; k<= j-1; k++){
			int temp_ans = recursive(A , i , k) + recursive(A , k+1 , j) + (A[i-1]*A[k]*A[j]);
			min_ans = Math.min(temp_ans , min_ans);
		}
		return min_ans;
	}

	public static int memoization(int A[]){
		int dp[][] = new int[1001][1001];
		for(int[] rows: dp)
			Arrays.fill(rows , -1);
		return memoize(A , 1 , A.length-1 , dp);
	}
	public static int memoize(int[] A , int i , int j , int[][] dp){
		if(i >= j)
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		int min_ans = Integer.MAX_VALUE;
		for(int k = i; k<= j-1; k++){
			int temp_ans = memoize(A , i , k , dp) + memoize(A , k+1 , j , dp) + (A[i-1]*A[k]*A[j]);
			min_ans = Math.min(temp_ans , min_ans);
		}
		dp[i][j] = min_ans;
		return dp[i][j];
	}
}
