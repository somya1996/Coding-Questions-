package Strings;
/*
Given string s, the task is to find the count of all substrings which have the same character at the beginning and end.

Example 1:

Input: s = "abcab"
Output: 7
Explanation: a, abca, b, bcab, c, a and b

Expected Time Complexity: O(|str|)
Expected Auxiliary Space: O(constant)
*/
import java.util.Scanner;

public class substring_with_similar_first_and_last_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		// TIME COMPLEXITY - O(n^2)
		/*
		int count = 0;
		for(int i=0; i<str.length(); i++)
			for(int j=i; j<str.length(); j++)
				if(str.charAt(i)== str.charAt(j))
					count++;
		System.out.println(count);
		*/
		int n = str.length();

		// Calculating frequency of each character
		// in the string.
		int[] count =  new int[26];
		for (int i = 0; i < n; i++)
			count[str.charAt(i)-'a']++;

		int result = 0;
		for (int i = 0; i < 26; i++)
			result += (count[i] * (count[i] + 1) / 2);

		System.out.println(result);


	}
}
