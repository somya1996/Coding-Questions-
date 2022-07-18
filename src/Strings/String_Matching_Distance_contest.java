package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class String_Matching_Distance_contest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String words[] = new String[n];
		sc.nextLine();
		for(int i=0; i<n; i++){
			words[i] = sc.nextLine();
		}
		int ans = minimum_difference(n , words);
		System.out.println(ans);
	}
	public static int minimum_difference(int n, String[] words) {
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				ans = Math.min(ans, cost(words[i], words[j]));
			}
		}

		return ans;
	}
	static int cost(String s, String t) {
		int ans = 0;
		for (int i = 0; i < s.length(); i++) {
			char ch1 = s.charAt(i);
			char ch2 = t.charAt(i);
			int op1 = Math.abs(ch1 - ch2);
			ans += op1;
		}
		return ans;
	}
}
