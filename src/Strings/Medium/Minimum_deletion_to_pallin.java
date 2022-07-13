package Strings.Medium;

import java.util.Scanner;

public class Minimum_deletion_to_pallin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int len1 = lps(s);
		int dos = s.length()-len1;
		System.out.println(dos);
	}
	//without recursion
	//Time complexity O(n^2)
	static int lps(String str) {
		int n = str.length();
		int L[][] = new int[n][n];
		for (int i = 0; i < n; i++)
			L[i][i] = 1;
		for (int cl = 2; cl <= n; cl++) {
			for (int i = 0; i < n - cl + 1; i++) {
				int j = i + cl - 1;
				if (str.charAt(i) == str.charAt(j) && cl == 2)
					L[i][j] = 2;
				else if (str.charAt(i) == str.charAt(j)) {
					L[i][j] = L[i + 1][j - 1] + 2;
				}
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}
		for(int i=0; i<n; i++) {
			for(int j =0; j<n; j++){
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println(L[0][n-1]);
		return L[0][n - 1];
	}
}
