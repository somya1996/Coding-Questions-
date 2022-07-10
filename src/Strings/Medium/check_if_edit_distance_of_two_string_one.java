package Strings.Medium;

import java.util.Scanner;

/*
An edit between two strings is one of the following changes.

Add a character
Delete a character
Change a character
Given two string s1 and s2, find if s1 can be converted to s2 with exactly one edit.
Expected time complexity is O(m+n) where m and n are lengths of two strings.
*/
public class check_if_edit_distance_of_two_string_one {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		boolean val = editdistance(s1 , s2);
		System.out.println(val);
	}

	private static boolean editdistance(String s1, String s2) {
		int count = 0;
		int m = s1.length();
		int n = s2.length();
		int i = 0 , j = 0;
		// to check if length diff is greater than 1
		if(Math.abs(m-n) > 1)
			return false;

		// if diff is 1 or having same length
		if( i < m && j < n){
			if(s1.charAt(i) != s2.charAt(j)){
				// if count is already 1 and one one character diff is there so it is not valid
				// need only one edit distance
				if(count == 1)
					return false;

				if(m > n)
					i++;
				else if( n > m)
					j++;
				else{
					i++;
					j++;
				}
				count++;
			}
			else{ // if characters are same
				i++;
				j++;
			}
		}
		if (i < m || j < n)
			count++;

		if(count == 1)
			return true;
		return false;
		//return count == 1;
	}

}
