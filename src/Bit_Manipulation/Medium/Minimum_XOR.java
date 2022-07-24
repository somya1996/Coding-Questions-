package Bit_Manipulation.Medium;

import java.util.Scanner;

/*
Given two integers A and B, find a number X such that A xor X is minimum possible, and the number of
set bits in X equals B.
Input :                          Output :
	A = 15                           12
	B = 2
*/
public class Minimum_XOR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int minimum_Xor = solve(a , b);
		System.out.println(minimum_Xor);
	}
	public static int solve(int A, int B) {
		int x = 0;
		for (int i = 31; i >= 0 && B>0; i--) {
			if (((1 << i) & A) > 0) {
				x |= (1 << i);
				B--;
			}
		}

		for (int i = 0; i <= 31 && B>0; i++) {
			if (((1 << i) & x) == 0) {
				x |= (1 << i);
				B--;
			}
		}
		return x;
	}
}
