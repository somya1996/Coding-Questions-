package Bit_Manipulation;

import java.util.Scanner;

public class add_two_no_without_arithmetic_use {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int sum = sum(a,b);
		System.out.println(sum);
	}
	public static int sum(int a , int b){
		while(b!=0){
			int carry = a&b;
			System.out.println("carry "+carry);
			a = a^b;
			System.out.println("a "+a);
			b = carry<<1;
			System.out.println("b "+b);
		}
		return a;
	}
}
