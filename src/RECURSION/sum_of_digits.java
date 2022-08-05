package RECURSION;

import java.util.Scanner;

public class sum_of_digits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = solve(n);
		System.out.println(ans);
	}
	public static int  solve (int A){
			if(A == 0)
				return 0;
			return (A%10) + solve(A/10);
	}
}
