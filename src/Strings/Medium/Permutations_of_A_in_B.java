package Strings.Medium;

import java.util.Scanner;

public class Permutations_of_A_in_B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int count = solve(a,b);
		System.out.println(count);
	}
	public static int solve(String A, String B) {
		int n = A.length();
		int m = B.length();
		int hash1[] = new int[26];
		int hash2[] = new int[26];
		for(int i=0; i<n; i++){
			hash1[A.charAt(i)-'a']++;
		}
		for(int i=0; i<n; i++){
			hash2[B.charAt(i)-'a']++;
		}
		int count = 0;
		if(same(hash1 , hash2)== true)
			count += 1;

		for(int i =n , j = 0; i<m; i++ , j++){
			hash2[B.charAt(j)-'a']--;
			hash2[B.charAt(i)-'a']++;
			if(same(hash1 , hash2)==true)
				count += 1;
		}

		return count;
	}
	public static boolean same(int[] hash1, int[] hash2) {
		for (int i = 0; i < 26; i += 1) {
			if (hash1[i] != hash2[i])
				return false; // not a permutation of A
		}
		return true; // got a permutation of A in G
	}
}
