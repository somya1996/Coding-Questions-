package Strings;
/*
Given a string S. Count the characters that have ‘N’ number of occurrences. If a character appears consecutively it is counted as 1 occurrence.

Example 1:

Input:
S = "abc", N = 1
Output: 3
Explanation: 'a', 'b' and 'c' all have 1 occurrence.

Input:
S = "geeksforgeeks", N = 2
Output: 4
Explanation: 'g', 'e', 'k' and 's' have
2 occurrences.
*/
import java.util.Arrays;
import java.util.Scanner;

public class Count_characters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		int c[] = new int[256];
		Arrays.fill(c,0);
		char w[] = s.toCharArray();
		char prev = ' ';
		for(int i=0; i<w.length; i++){
			if(prev!=w[i]) {
				c[w[i] - '0']++;
				prev = w[i];
			}
		}
		for(int i=0; i<c.length; i++){
			System.out.print(c[i]+" ");
		}
		System.out.println();
		int count = 0;
		for(int i=0; i<c.length; i++){
			if(c[i] == n)
				count++;
		}
		System.out.println("count"+count);
	}
}
