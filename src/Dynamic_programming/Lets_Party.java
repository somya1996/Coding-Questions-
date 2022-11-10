package Dynamic_programming;

import java.util.Scanner;

public class Lets_Party {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans  = solve(n);
		System.out.println(ans);
	}
	public static int solve(int A) {
		int mod = 10003;
		if(A == 1 || A == 2)
			return A;
		int[] dp = new int[A+1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=A; i++){
			dp[i] = (dp[i-1]%mod + (i-1)*dp[i-2]%mod)%mod;
		}
		return dp[A]%mod;
	}
}
