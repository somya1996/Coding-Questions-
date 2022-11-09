package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Unique_path {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j =0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		Unique_path up = new Unique_path();
		//TOP - DOWN APPROACH
		int ans =up.uniquePathsWithObstacles(arr);
		System.out.println(ans);
	}
	public int uniquePathsWithObstacles(int[][] A) {
		int[][] dp = new int[A.length][A[0].length];
		if(A[0][0]==1) return 0;
		dp[0][0] = 1;

		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}

		for(int i=1; i<A.length; i++){
			if(A[i][0] == 0)
				dp[i][0] = dp[i-1][0];
			else
				dp[i][0] = 0;
		}
		for(int i=1; i<A[0].length; i++){
			if(A[0][i] == 0)
				dp[0][i] = dp[0][i-1];
			else
				dp[0][i] = 0;
		}
		for(int i=1; i<A.length; i++){
			for(int j=1; j<A[0].length; j++){
				if(A[i][j] == 0)
					dp[i][j] = dp[i-1][j]+dp[i][j-1];
				else
					dp[i][j] = 0;
			}
		}
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				System.out.print(dp[i][j]+" ");
			}
			System.out.println();
		}
		return dp[A.length-1][A[0].length-1];
	}
}