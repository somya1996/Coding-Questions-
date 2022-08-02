package Array.medium_level;

import java.util.Scanner;
/*
Given a string A. Find the rank of the string amongst its permutations sorted lexicographically.
Assume that no characters are repeated.

Note: The answer might not fit in an integer, so return your answer % 1000003
*/
public class Sorted_permutation_rank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		int ans = findRank(n);
		System.out.println(ans);
	}
	public static int findRank(String A) {
		int mod = 1000003;
		long count = 0;
		long ans = 0;
		int n = A.length();
		for(int i = 0; i < n; i++) {
			count = 0;
			for (int j = i + 1; j < n; j++) {
				if (A.charAt(j) < A.charAt(i)) {
					count++;
				}
			}
			ans += (count * fact(n - i - 1)) % mod;
		}
		return (int)(ans+1)%mod;
	}
	static long fact(int n){
		if(n==0)
			return 1;
		int mod = 1000003;
		return (n * fact(n-1))%mod;
	}
}
