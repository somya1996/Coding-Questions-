package Bit_Manipulation.Medium;

import java.util.Scanner;

public class clear_bits_in_range {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int r = sc.nextInt();
		int ans = changebits(n , l , r);
		System.out.println(ans);
	}
	public static int changebits(int n , int l , int r){
		int mask = (1<<(l-1))-1;
		System.out.println("left shift "+mask);
		int new_mask = (1<<r)-1;
		System.out.println("right shift "+new_mask);
		int newans = mask^new_mask;
		return newans^n;
	}
}
