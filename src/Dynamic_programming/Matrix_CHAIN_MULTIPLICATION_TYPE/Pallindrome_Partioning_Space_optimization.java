package Dynamic_programming.Matrix_CHAIN_MULTIPLICATION_TYPE;

import java.util.Arrays;
import java.util.Scanner;

public class Pallindrome_Partioning_Space_optimization {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();

		int ans1 = memoization(A);
		System.out.println(ans1);
	}
	public static boolean isPallindrome(String A , int i , int j){
		while(i < j)
		{
			if(A.charAt(i) != A.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	public static int memoization(String A){
		int dp[][] = new int[1001][1001];
		for(int[] rows: dp)
			Arrays.fill(rows , -1);
		return memoize(A , 0 , A.length()-1 , dp);
	}
	public static int memoize(String A , int i , int j , int[][]dp){
		if( i >= j )
			return 0;
		if(isPallindrome(A, i, j) )
			return 0;
		if(dp[i][j] != -1)
			return dp[i][j];
		//HINT:
		// There may be a case that :
		// memoize(A , i , k , dp) is already present in dp so no need to search again
		// memoize(A , k+1 , j , dp) is already present in dp so no need to search again
		// so no need to create another function just print the output there only
		int min_ans = Integer.MAX_VALUE;
		int left , right;
		for(int k = i; k<=j-1; k++){
			if(dp[i][k] != -1)
				left = dp[i][k];
			else
				left = memoize(A , i , k , dp);
			//dp[i][j] = left;

			if(dp[k+1][j] != -1)
				right = dp[k+1][j];
			else
				right = memoize(A , k+1 , j , dp);

			int temp = 1 + left + right;

			min_ans = Math.min(min_ans , temp);
		}
		dp[i][j] = min_ans;
		return dp[i][j];
	}
}
