package Dynamic_programming;

import java.util.Scanner;

public class Maximum_sum_with_2Xn_grid_with_no_adjacent {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] A = new int[2][n];

		for(int i=0; i<2; i++){
			for(int j=0; j<n; j++){
				A[i][j] = sc.nextInt();
			}
		}
		int ans1 = adjacent_recusively(A);
		System.out.println(ans1);

		int ans2 = bottom_up(A);
		System.out.println(ans2);
	}
	public static int adjacent_recusively(int[][] A) {
		return recursive_solve(A , 0 , A[0].length);
	}
	 public static int recursive_solve(int[][] grid , int index , int n){
		if(index>=n)
			return 0;
		int max_ele = Math.max(grid[0][index] , grid[1][index]);
		int incl = max_ele + recursive_solve(grid , index+2 , n);
		int excl = 0 + recursive_solve(grid , index+1, n);
		return Math.max(incl , excl);
	 }

	 public static int bottom_up(int[][] A){
		int dp[] = new int[A[0].length+1];
		dp[0] = Math.max(A[0][0] , A[1][0]);
		for(int i=1; i<=A[0].length; i++){
			int max = Math.max(A[0][i] , A[1][i]);
			int incl = max + dp[i-2];
			int excl = dp[i-1];
			dp[i] = Math.max(incl , excl);
		}
		return dp[A[0].length];
	 }
}
