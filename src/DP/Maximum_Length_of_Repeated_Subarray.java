package DP;

import java.util.Scanner;

public class Maximum_Length_of_Repeated_Subarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num1[] = new int[n];
		for(int i=0; i<n; i++)
			num1[i] = sc.nextInt();

		int num2[] = new int[n];
		for(int i=0 ; i<n ; i++)
			num2[i] = sc.nextInt();

		int len = findLength(num1 , num2);
		System.out.println(len);
	}
	public static  int findLength(int[] A, int[] B ){
		if(A == null||B == null) return 0;
		int m = A.length;
		int n = B.length;
		int max = 0;
		//dp[i][j] is the length of longest common subarray ending with nums[i] and nums[j]
		int[][] dp = new int[m + 1][n + 1];
		for(int i = 0;i <= m;i++){
			for(int j = 0;j <= n;j++){
				if(i == 0 || j == 0){
					dp[i][j] = 0;
				}
				else{
					if(A[i - 1] == B[j - 1]){
						dp[i][j] = 1 + dp[i - 1][j - 1];
						max = Math.max(max,dp[i][j]);
					}
				}
			}
		}
		return max;
	}
}
