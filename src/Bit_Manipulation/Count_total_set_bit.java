package Bit_Manipulation;

import groovy.console.ui.SystemOutputInterceptor;

import java.util.Scanner;

public class Count_total_set_bit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		//System.out.println(n);
		System.out.println(countSetBits(n));
	}
	public static int countSetBits(int n){
		/*int count2 = 0;
		// This takes O(nlog(max))  max is 32 bit(bit for binary representation)
		for(int i=1; i<=n; i++){
			int count = 0 ;
			int a = i;
			while(a != 0){
				int l_b = a & 1;
				count = count + l_b;
				System.out.println(" inner count "+count);
				a = a>>1;
			}
			count2 += count;
			System.out.println(" outer count "+count2);
		}
		return count2;*/

		// using recursion
		//System.out.println(" In recursion ");
		if(n == 0)
			return 0;
		int x = last_digit_power_of_2( n );
		//System.out.println(x);
		int total_bits_upto_power = (x) * (1 << (x-1));
		int remaining = n - (1<<x) + 1;
		int rest = n - (1 << x);
		int count = total_bits_upto_power + remaining * 1 + countSetBits(rest);

		return count;
	}

	public static int last_digit_power_of_2(int n){
		//System.out.println(" in last_digit_power loop");
		int x = 0;
		while(( 1 << x )<=n){
			x++;
		}
		return x-1;
	}
}
