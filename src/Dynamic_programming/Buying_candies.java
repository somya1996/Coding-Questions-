package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Buying_candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//System.out.println("candies");
		int candies[] = new int[n];
		for(int i=0; i<n; i++){
			candies[i] = sc.nextInt();
		}
		//System.out.println("sweetness");
		int sweetness[] = new int[n];
		for(int i=0; i<n; i++){
			sweetness[i] = sc.nextInt();
		}
		//System.out.println("cost");
		int cost[] = new int[n];
		for(int i=0; i<n; i++){
			cost[i] = sc.nextInt();
		}

		int money = sc.nextInt();

		int ans = recursive_buying(candies , sweetness , cost , money);
		System.out.println(ans);

		int ans1 = memoization(candies , sweetness , cost , money);
		System.out.println(ans1);

		int ans2 = tabulation(candies , sweetness , cost , money);
		System.out.println(ans2);
	}
	public static int recursive_buying(int[] candy, int[] sw, int[] cost, int m) {
		return recursively(candy , sw , cost , m , candy.length);
	}
	public static int recursively(int[] candy , int[]sw , int[]cost , int money , int n){
		if(n == 0)
			return 0;
		if(money < cost[n-1])
			return recursively(candy , sw , cost , money , n-1);
		else//(money >= cost[n-1])
			return Math.max(sw[n-1]*candy[n-1] + recursively(candy , sw , cost , money-cost[n-1] , n)
					, recursively(candy , sw , cost , money , n-1));
	}

	public static int memoization(int[] candy, int[] sw, int[] cost, int m){
		int dp[][] = new int[candy.length+1][m+1];
		for(int[] rows: dp){
			Arrays.fill(rows , -1);
		}
		return memoize(candy , sw , cost , m , candy.length , dp);
	}
	public static int memoize(int[] candy, int[] sw, int[] cost, int m , int n , int[][]dp){
		if(n == 0)
			return 0;

		if(dp[n][m] != -1)
			return dp[n][m];

		if(m < cost[n-1])
			dp[n][m] = memoize(candy , sw , cost , m , n-1 , dp);
		else if(m >= cost[n-1])
			dp[n][m] = Math.max(sw[n-1]*candy[n-1] + memoize(candy , sw , cost , m-cost[n-1] , n , dp)
					, memoize(candy , sw , cost , m , n-1 , dp));
		return dp[n][m];
	}
	public static int tabulation(int[] candy, int[] sw, int[] cost, int money){
		int[] dp = new int[money + 1];
		Arrays.fill(dp, 0);
		for (int i = 0; i < cost.length; i++) {
			for (int j = cost[i]; j <= money; j++) {
				dp[j] = Math.max(dp[j], dp[j - cost[i]] + candy[i] * sw[i]);
			}
		}
		return dp[money];
	}
}
