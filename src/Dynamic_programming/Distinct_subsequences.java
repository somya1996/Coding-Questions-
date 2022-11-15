package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Distinct_subsequences {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();

		int ans  = recursive_distinct_ways(A , B);
		System.out.println(ans);

		int ans1 = memoization(A , B);
		System.out.println(ans1);

		int ans2 = tabulation(A , B);
		System.out.println(ans2);
	}
	public static int recursive_distinct_ways(String A, String B) {
		return  recursive(A , B , A.length() , B.length());
	}
	public static int recursive(String A , String B , int n , int m){
		//Base case
		if(m == 0)
			return 1;
		if(n == 0)
			return 0;

		if(A.charAt(n-1) == B.charAt(m-1))
			return recursive(A , B , n-1 , m-1) + recursive(A ,B , n-1 , m);
		else
			return recursive(A , B , n-1 , m);
	}

	public static int memoization(String A , String B){
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int[] rows : dp){
			Arrays.fill(rows , -1);
		}
		return memoize(A , B , A.length() , B.length() , dp);
	}
	public static int memoize(String A , String B , int n , int m , int[][]dp){
		if(m == 0)
			return 1;
		if(n == 0)
			return 0;
		if(dp[n][m] != -1)
			return dp[n][m];
		if(A.charAt(n-1) == B.charAt(m-1))
			dp[n][m] =  memoize(A , B , n-1 , m-1 , dp) + memoize(A , B , n-1 , m , dp);
		else
			dp[n][m] = memoize(A , B , n-1 , m , dp);
		return dp[n][m];
	}

	public static int tabulation(String A , String B){
		int[][] dp = new int[A.length()+1][B.length()+1];
		for(int i=0; i<= A.length(); i++){
			for(int j=0; j<= B.length(); j++){
				if(j == 0)
					dp[i][j] = 1;
				if(i == 0)
					dp[i][j] = 0;
				if(A.charAt(i-1) == B.charAt(j-1))
					dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
				else
					dp[i][j] = dp[i-1][j];
			}
		}
		return dp[A.length()][B.length()];
	}
}
