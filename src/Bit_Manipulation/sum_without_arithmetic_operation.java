package Bit_Manipulation;

import java.util.Scanner;

public class sum_without_arithmetic_operation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int carry = a&b;
		int sum = a^b;
		while(carry>0){
			int shift = carry<<1;
			carry = carry & shift;
			sum = sum ^ shift;
		}
		System.out.println(sum);
	}
}
