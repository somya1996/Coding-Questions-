package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class DungeonGame{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int ans = calculateMinimumHP(arr);
		System.out.println(ans);
	}
	//using top down memoization
	public static int calculateMinimumHP(int[][] dungeon){
		int[][] dp = new int[dungeon.length][dungeon[0].length];
		return memoization(dungeon , dp, 0 , 0);
	}
	public static int memoization(int[][] dungeon , int[][]dp , int r , int c) {
		if(dp[r][c] != 0)
			return dp[r][c];

		if(r == dungeon.length - 1 && c == dungeon[0].length - 1){
			dp[r][c] = dungeon[r][c] < 0 ? -dungeon[r][c] + 1 : 1; //The minimum is 1
			return dp[r][c];
		}

		// recursive case
		int min_energy_needed = Integer.MAX_VALUE;
		if(r < dungeon.length-1) {
			int go_right = memoization(dungeon, dp , r+1, c);
			min_energy_needed = Math.min(min_energy_needed , go_right);
		}
		if(c < dungeon[0].length-1) {
			int go_left = memoization(dungeon, dp , r, c+1);
			min_energy_needed = Math.min(min_energy_needed , go_left);
		}
		if(dungeon[r][c] >= min_energy_needed)
			min_energy_needed = 1;
		else
			min_energy_needed = min_energy_needed - dungeon[r][c];
		dp[r][c] = min_energy_needed;
		return min_energy_needed;
	}
}
/*if(dungeon.length == 1 && dungeon[0].length == 1){
            if(dungeon[0][0] < 0)
                return Math.abs(dungeon[0][0])+1;
            else
                return 1;
        }
		int dp[][] = new int[dungeon.length][dungeon[0].length];
		dp[0][0] = dungeon[0][0];
		// row
		for(int i=1; i<dungeon.length; i++){
			dp[i][0] = dungeon[i][0] + dp[i-1][0];
		}
		//column
		for(int i=1; i<dungeon[0].length; i++){
			dp[0][i] = dungeon[0][i] + dp[0][i-1];
		}
		for(int i=1; i<dungeon.length; i++){
			for(int j=1; j< dungeon[0].length; j++){
				int val;
				if(Math.abs(dp[i-1][j])<Math.abs(dp[i][j-1]))
					val = dp[i-1][j];
				else
					val = dp[i][j-1];
				dp[i][j] = dungeon[i][j] + val;
			}
		}
		return Math.abs(dp[dungeon.length-1][dungeon[0].length-1])+1;*/