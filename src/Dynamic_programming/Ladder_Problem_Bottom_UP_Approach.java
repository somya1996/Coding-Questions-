package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Ladder_Problem_Bottom_UP_Approach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Ladder_Problem_Bottom_UP_Approach lp = new Ladder_Problem_Bottom_UP_Approach();
		int ans = lp.climbStairs(n);
		System.out.println(ans);
	}
	// recursive approach

	/*public int  climbStairs(int A){
		if(A == 0)
			return 1;
		if(A == 1 || A == 2)
			return A;
		return climbStairs(A-1)+climbStairs(A-2);
	}*/

	// Bottom-up Approach

	/*public int climbStairs(int A) {
		long mod = 1000000007;
		if(A == 1 || A==2)
			return A;
		long[] dp = new long[A+1];
		Arrays.fill(dp , -1L);
		step(dp , A);
		return (int)(dp[A]%mod);
	}
	public void step(long[] dp , int A){
		long mod = 1000000007;
		dp[0] = 1;
		dp[1] = 1;
		for(int i=2; i<=A; i++){
			dp[i] = (dp[i-1]%mod + dp[i-2]%mod)%mod;
		}
	}*/

	// top-Down (Memoization) Approach

	public int climbStairs(int A){
		long mod = 1000000007;
		long[] dp = new long[A+1];
		Arrays.fill(dp , -1L);
		return no_of_step(dp , A);
	}
	public int no_of_step(long[] dp , int A){
		long mod = 1000000007;
		if(A == 1 || A == 2)
			return A;
		if(dp[A] == -1){
			dp[A] = no_of_step(dp , A-1)+no_of_step(dp , A-2);
		}
		return (int)(dp[A]%mod);
	}
}
