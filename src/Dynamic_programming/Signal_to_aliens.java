package Dynamic_programming;

import java.util.Scanner;

public class Signal_to_aliens{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ans = recursively(n);
		System.out.println(ans);

		int ans1 = tabulation(n);
		System.out.println(ans1);
	}
	public static int recursively(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 2;
		if(n == 2)
			return 3;
		return recursively(n-1)+recursively(n-2);
	}
	public static int tabulation(int A) {
		if(A == 1)
			return 2;
		if(A == 2)
			return 3;
		int mod = (int)1000000007;
		int[] dp = new int[A+1];
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 3;
		for(int i=3; i<=A; i++){
			dp[i] = (dp[i-1]%mod + dp[i-2]%mod)%mod;
		}
		return dp[A]%mod;
	}
}
