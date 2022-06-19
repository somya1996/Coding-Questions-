package Bit_Manipulation;

import java.util.Scanner;

public class Check_Kth_bit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean ans = checkKthBit(n,k);
		System.out.println(ans);
	}
	static boolean checkKthBit(int n, int k){
		int mask = 1<<k;
		int z = n & mask;
		if(z == 0)
			return false;
		return true;
	}
}
