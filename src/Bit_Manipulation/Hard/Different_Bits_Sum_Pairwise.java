package Bit_Manipulation.Hard;

import java.util.Scanner;

public class Different_Bits_Sum_Pairwise {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(cntBits(arr));
	}
	public static int cntBits(int[] A) {

		long mod = 1000000007;
		long total = 0;
		for(int i = 0; i < 32; i++) {
			long counton = 0;
			for (int j = 0; j < A.length; j++) {
				if ((A[j] & (1 << i)) != 0) {
					counton++;
				}
			}
			long countoff = A.length - counton;
			// difference_bit is differece of two bits and its pairwise so are multiplying 2
			total += counton * countoff * 2;
			total = total%mod;
		}
		return (int)total;
	}

}
