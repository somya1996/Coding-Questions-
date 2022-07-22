package Bit_Manipulation;

import java.util.Scanner;

public class Reverse_the_number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(reverseNum(n));
	}
	public static int reverseNum(int n) {
		int rev = 0;
		// traversing bits of 'n'
		// from the right
		while (n > 0)
		{
			// bitwise left shift
			// 'rev' by 1
			rev = rev << 1;

			// if current bit is '1'
			if ((int)(n & 1) == 1)
				rev ^= 1;

			// bitwise right shift
			//'n' by 1
			n = n >> 1;
		}
		// required number
		return rev;
	}
}
