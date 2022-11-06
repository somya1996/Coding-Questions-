package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Fibonnaci_Series {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = recursive(n);
		System.out.println(ans);

		int ans1 = Bottom_up(n);
		System.out.println(ans1);

		int ans2 = Top_Down(n);
		System.out.println(ans2);
	}
	//Recursive Approach
	public static int recursive(int n) {
		if(n == 0 || n == 1)
			return n;
		return recursive(n-1)+recursive(n-2);
	}
	//Botton-Up Approach
	public static int Bottom_up(int n){
		if(n == 0 || n == 1)
			return n;
		int[] series = new int[n+1];
		Arrays.fill(series , 0);
		solve(series , n);
		return series[n];
	}
	public static void solve(int[]series , int n){
		series[0] = 0;
		series[1] = 1;
		for(int i=2; i<=n; i++){
			series[i] = series[i-1]+series[i-2];
		}
	}
	//Top_Down Approach
	public static int Top_Down(int n){
		int[] dp = new int[n+1];
		Arrays.fill(dp , 0);
		return solve1(dp , n);
	}
	public static int solve1(int[] dp , int A){
		if(A == 0 || A == 1)
			return A;
		if(dp[A] == 0){
			dp[A] = solve1(dp , A-1) + solve1(dp , A-2);
		}
		return dp[A];
	}
}
