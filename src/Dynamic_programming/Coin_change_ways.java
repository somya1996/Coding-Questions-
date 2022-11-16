package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_change_ways {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int money = sc.nextInt();

		int ans1 = coinchange2_recusive(arr , money);
		System.out.println(ans1);

		int ans2 = tabulation(arr , money);
		System.out.println(ans2);
	}
	public static int coinchange2_recusive(int[] arr, int money) {
		return recursive(arr , money , arr.length);
	}
	public static int recursive(int[] arr , int money , int index){
		if(money == 0){
			return 1;
		}
		//if(money < 0)
		//	return 0;
		if(index == 0)
			return 0;
		if(arr[index - 1] <= money)
			return recursive(arr , money-arr[index-1] , index) + recursive(arr , money , index-1);
		else
			return recursive(arr , money , index-1);
	}

	public static int tabulation(int[] coins , int money){
		// create dp
		int[][] dp = new int[coins.length+1][money+1];
		for(int i=0; i<=money; i++)
			dp[0][i] = 0;
		for(int i=0; i<=coins.length; i++)
			dp[i][0] = 1;
		for(int i=1; i<=coins.length; i++){
			for(int j=1; j<=money ; j++){
				if(j >= coins[i-1])
					dp[i][j] = dp[i][j-coins[i-1]] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[coins.length][money];
	}
}