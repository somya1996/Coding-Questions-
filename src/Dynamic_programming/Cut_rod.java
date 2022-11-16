package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Cut_rod{
	public static void main(String[] args) {
		int arr[] = { 3, 4 ,1 ,6 ,2 };

		int ans = recursively(arr);
		System.out.println(ans);

		int ans1 = memoization(arr);
		System.out.println(ans1);

		int ans2 = tabulation(arr);
		System.out.println(ans2);

		int ans3 = space_optimization(arr);
		System.out.println(ans3);
	}
	/** Hint : HERE MAIN THING IS:-
	 * index starts from 0 to n-1
	 * len is going from 1 to n
	 * So, if we are passing len of size 5 then its price will be at index 4 this we need to track
	 * now we dont want to take particular element then we will do index -2 becoz
	        ->  index -1 is for skipping that particular element
	        ->  index-2 : one more -1 is to track that index is moving one element less than the length
	 * */
	public static int recursively(int[] arr){
		return recursive(arr , arr.length , arr.length);
	}
	public static int recursive(int[] p , int len , int index){
		if(len == 0 || index == -1)
			return 0;

		int cut = 0;
		if(len >= index){
			cut = p[index-1] + recursive(p , len-index , index);
		}
		int notcut = recursive(p , len , index-2);
		return Math.max(cut , notcut);
	}
	// ONE MORE WAY to solve this question
	public static int memoization(int[] A) {
		int dp[][] = new int[A.length+1][A.length + 1];
		for (int i = 0; i < A.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		return cutRod(A , A.length-1 , A.length , dp);
	}
	private static int cutRod(int price[], int index, int n, int[][] dp)
	{
		// base case
		if (index == 0) {
			return n * price[0];
		}

		if (dp[index][n] != -1) {
			return dp[index][n];
		}

		int notCut = cutRod(price, index - 1, n, dp);
		int cut = Integer.MIN_VALUE;
		int rod_length = index + 1;

		if (rod_length <= n) {
			cut = price[index] + cutRod(price, index, n - rod_length, dp);
		}
		return dp[index][n] = Math.max(cut, notCut);
	}

	public static int tabulation(int[] A){
		int[][] dp = new int[A.length][A.length+1];
		for(int len=0; len<=A.length; len++)
			dp[0][len] = A[0]*len;

		for(int idx = 1; idx<A.length; idx++){
			for(int len=0; len<=A.length; len++){
				int not_cut = dp[idx-1][len];
				int rodlength = idx+1;
				int cut = Integer.MIN_VALUE;
				if(rodlength <= len)
					cut = dp[idx][len-rodlength] + A[idx];
				dp[idx][len] = Math.max(cut , not_cut);
			}
		}
		return dp[A.length-1][A.length];
	}
	// Space Optimization
	public static int space_optimization(int[] A){
		int n = A.length;
		int[] val = new int[n + 1];
		val[0] = 0;

		// Build the table val[] in bottom up manner and return the last entry from the table
		for (int i = 1; i <= n; i++) {
			int max_val = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++)
				max_val = Math.max(max_val, A[j] + val[i - j - 1]);
			val[i] = max_val;
		}

		return val[n];
	}
}