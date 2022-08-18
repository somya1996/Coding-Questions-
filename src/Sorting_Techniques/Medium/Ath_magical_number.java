package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Ath_magical_number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int ans = solve(A , B , C);
		System.out.println(ans);
	}

/*
	public static int solve(int A, int B, int C) {
		long lcm = (long) B * C / gcd(B, C);
		long low = 1, high = (long)A*Math.min(B,C), ans = 2;
		while (low <= high) {
			long mid = (high - low) / 2 + low;
			// count numbers <= mid divisible by B, C and both B, C.
			long cntB = mid / B, cntC = mid / C, cntBC = mid / lcm;
			if (cntB + cntC - cntBC >= A) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return (int)(ans % (1000 * 1000 * 1000 + 7));
	}*/
	public static int solve(int A, int B, int C){
		int bc = B/gcd(B,C)*C;
		int start = 1 , end = A*Math.min(B,C);
		int mod = (int)1000000007;
		int ans = -1;
		while(start <= end){
			int mid = ((start+end)/2);
			//System.out.println(mid);
			//int total = (mid/B) + (mid/C) - (mid/bc);
			if(((mid/B) + (mid/C) - (mid/bc)) >= A){
				ans = mid;
				end = mid-1;
			}
			else
				start = mid + 1;
		}
		return (int)(ans%mod);
	}
	public static int gcd(int x, int y) {
		if (x == 0)
			return y;
		return gcd(y % x, x);
	}
}
