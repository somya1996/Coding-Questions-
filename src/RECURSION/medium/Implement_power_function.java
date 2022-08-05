package RECURSION.medium;

import java.util.Scanner;

public class Implement_power_function {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int ans = solve(A , B , C);
		System.out.println(ans);
	}
	public static int solve(int A , int B , int C){
		// without recursion
		/*
		long a = A;
		long res = 1L;
		while (B > 0) {
			if (B % 2 == 1) {
				res *= a;
				res %= C;
			}
			a *= a;
			a %= C;
			B = B >> 1;
		}
		res = (res + C) % C;
		return (int) res;
		*/

		// with recursion
		if(A == 0)
			return 0;
		if( B == 0)
			return 1;
		long p = (long)solve(A, B/2, C);
		if(B % 2 == 0) {
			return (int)((p%C * p%C)+C) % C;
		}else{
			return (int)((A%C * p%C * p%C)+C) % C;
		}
	}
}
