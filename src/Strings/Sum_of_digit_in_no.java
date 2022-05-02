package Strings;
/*
Given a string str containing alphanumeric characters. The task is to calculate the sum of all the
numbers present in the string.

Example 1:

Input:
str = 1abc23
Output: 24
Explanation: 1 and 23 are numbers in the
string which is added to get the sum as
24.
*/
import java.util.Scanner;

public class Sum_of_digit_in_no {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(findSum(s));
	}
	public static long findSum(String str)
	{
		int sum = 0 , num = 0;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)>='0' && str.charAt(i)<='9'){
				int ch = Character.getNumericValue(str.charAt(i));
				num = num*10+ch;
			}
			else{
				sum += num;
				num = 0;
			}
		}
		return sum+num;
	}
}
