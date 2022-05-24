package Array;

import java.util.Arrays;
import java.util.Scanner;

public class bit_reverse_32bit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long ans = reverse(A);
		System.out.println(ans);
	}
	public static long reverse(final long A) {
		long B = A;
		long sum = 0;
		int idx = 31;
		while(B!=0){
			long rem = B%2;
			sum += rem<<idx--; //curr -- becoz 1st - 32nd value then 2nd - 31st value
			B /= 2;
		}
		return sum;
	}
}
