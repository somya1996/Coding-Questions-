package Dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class Decode_Ways {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Decode_Ways dw = new Decode_Ways();

		int ans = dw.numDecodings_recursive(s);
		System.out.println(ans);

		int ans1 = dw.topdown(s);
		System.out.println(ans1);
	}
	public int numDecodings_recursive(String s) {
		return recursively(s , 0);
	}
	public static int recursively(String s , int i){
		// base case
		if(i == s.length())
			return 1;
		if(s.charAt(i) == '0')
			return 0;
		// recursive case
		int count = recursively(s , i+1);
		if(i<s.length()-1 && (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<27)
			count += recursively(s , i+2);
		return count;
	}
	public int topdown(String s){
		int dp[] = new int[s.length()];
		Arrays.fill(dp , -1);
		return top_down(s , 0 , dp);
	}
	public int top_down(String s , int i , int[]dp){
		int n = s.length();
		if (i == n)
			return 1;
		if (s.charAt(i) == '0')
			return 0;
		if (dp[i] != -1)//if this sub-problem has already been solved, don't go and invoke another series of recursive call. Get the result from cache
			return dp[i];
		int count = top_down(s, i + 1, dp);
		if (i < n - 1 && ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0')) < 27) {
			count += top_down(s, i + 2, dp);
		}
		return dp[i] = count;
	}
	/**
	 * This function gives us the count of ways a number can be decoded. We would need to apply the same
	 * function to a smaller input and have faith that it'd work.
	 * For that we take an index i which goes from 0 to n - 1 where n is the length of string.
	 * Now this function becomes:
	        public int numDecodings(String s, int i) {...}
	 * Now we need to write a base condition. Base condition can be derived from thinking of the smallest
	 * possible input for the question. Question gives us that the minimum length of string is 1.
	 * If we start from i = 0 and reach i = 1, then we see that there is just one way to decode

	 * So, the base condition becomes:
	        if(i == n) return 1;
	 * Another condition that's given in question is if 0 is leading, there is no possible way
	        if(s.charAt(i) == '0') return 0;

	 *  question asks us to either select 1 or 2 digits at any point.so we'll write a function which gives us the count of ways:
	 *  we move i to next position by either i + 1 or i + 2 (because these are the two choices and we code
	 *  for our choices in recursion). Note that the string becomes smaller as I move forward.
	 *  When I code for these two choices, the recursive calls become:
	        numDecodings(s, i + 1) and numDecodings(s, i + 2);

	 * Need to return total ways so count of these two
	 * if( we are checking 2 index value and we are at index i so, need to check do i+1 exist in string or not)
	        if(i<s.length()-1 && (s.charAt(i)-'0')*10+(s.charAt(i+1)-'0')<27)
	 */

}