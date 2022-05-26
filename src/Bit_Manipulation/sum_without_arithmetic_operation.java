package Bit_Manipulation;

import java.util.Scanner;

public class sum_without_arithmetic_operation {
	public static void main(String[] args) {
		// one way is using loop
		/*for(int i=0;i<b;i++){
			a++;
		}*/
		//other way using bit manipulation
		Scanner sc = new Scanner(System.in);
		int start = (int)System.currentTimeMillis();
		int a = sc.nextInt();
		int b = sc.nextInt();
		while(b!=0){
			int carry = a&b; // this is to check carry
			System.out.println(carry);
			a = a^b;  // this is for addition substitution
			System.out.println(a);
			b = carry<<1;  // now left shift the carry for other
			System.out.println(b);
			System.out.println();
		}
		System.out.println(a);
		int end = (int)System.currentTimeMillis();
		System.out.println("Time taken :"+(end - start));
	}


}
