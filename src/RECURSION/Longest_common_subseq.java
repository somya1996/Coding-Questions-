package RECURSION;

import Strings.Medium.Longest_common_substring;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_common_subseq {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		Longest_common_subseq lcs = new Longest_common_subseq();
		// recursion
		//int len1 = lcs.LCSubseq(s1, s2, s1.length(), s2.length());  // using recursion
		//System.out.println(len1);

	}


	// ******  using recursion   ******   TC - O(2^n)

	int LCSubseq(String S1, String S2, int n, int m) {
		//base case
		if (n == 0 || m == 0)
			return 0;
		if (S1.charAt(n - 1) == S2.charAt(m - 1)) {
			//System.out.println(S1.charAt(n-1));
			return 1 + LCSubseq(S1, S2, n - 1, m - 1);
		}
		else
			return Math.max(LCSubseq(S1, S2, n, m - 1), LCSubseq(S1, S2, n - 1, m));

	}
	// other ways is in DP (optimised way)

}
