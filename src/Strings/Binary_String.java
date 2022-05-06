package Strings;

import java.util.Scanner;

/*
Given a binary string S. The task is to count the number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.

Example 1:

Input:
N = 4
S = 1111
Output: 6
Explanation: There are 6 substrings from the given string. They are 11, 11, 11, 111, 111, 1111.
*/
public class Binary_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s= sc.nextLine();
		int count = 0;
		for(int i=0; i<s.length();i++){
			if(s.charAt(i)=='1'){
				count ++;
			}
		}
		int sub = (count*(count-1))/2;
		System.out.println(sub);
	}
}
