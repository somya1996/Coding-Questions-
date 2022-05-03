package Strings;

import java.util.Scanner;

/*
Given an integer N and an integer D, rotate the binary representation of the integer N by D digits to the left as well as right and print the results in decimal values after each of the rotation.
Note: Integer N is stored using 16 bits. i.e. 12 will be stored as 0000.....001100.

Example 1:

Input:
N = 28, D = 2
Output:
112
7
Explanation: 28 in Binary is:
000...011100
Rotating left by 2 positions, it becomes
00...1110000 = 112 (in decimal).
Rotating right by 2 positions, it becomes
000...000111 = 7 (in decimal).
*/
public class Rotate_bits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d = sc.nextInt();

		String str = Integer.toBinaryString(n);
		System.out.println("Binary String "+str);


		String zeroes = "";
		for(int i=0; i<16-str.length(); i++)
			zeroes += '0';

		str=zeroes+str;
		String ans1=str.substring(d)+str.substring(0,d);
		System.out.println(" Left Shift "+ ans1);
		System.out.println(Integer.parseInt(ans1,2));
		String sub1=str.substring(16-d);
		String sub2=str.substring(0,16-d);
		String ans2 = sub1+sub2;
		System.out.println(" Right Shift "+ ans2);
		System.out.println(Integer.parseInt(ans2,2));
	}
}
