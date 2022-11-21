package Dynamic_programming.Matrix_CHAIN_MULTIPLICATION_TYPE;

import org.apache.groovy.parser.antlr4.AbstractLexer;

import java.util.Arrays;
import java.util.Scanner;

public class Pallindrome_Partitioning {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();

		int ans = recursively(A);
		System.out.println(ans);

		int ans1 = memoization(A);
		System.out.println(ans1);
	}
	public static int recursively(String A){
		return recursive_partitioning(A , 0 , A.length()-1);
	}
	// using recursion will throw stack overflow because it will give time complexity as exponential
	public static int recursive_partitioning(String A , int i , int j){
		if( i >= j || isPallindrome(A, i, j) )
			return 0;
		int ans = Integer.MAX_VALUE, count;
		for(int k = i; k < j; k++)
		{
			count = recursive_partitioning(A, i, k) +
					recursive_partitioning(A, k + 1, j) + 1;

			ans = Math.min(ans, count);
		}
		return ans;
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

		int min_ans = Integer.MAX_VALUE;
		for(int k = i; k<=j-1; k++){
			int temp = memoize(A , i , k , dp) + memoize(A , k+1 , j , dp) + 1;
			min_ans = Math.min(min_ans , temp);
		}
		dp[i][j] = min_ans;
		return dp[i][j];
	}
}
