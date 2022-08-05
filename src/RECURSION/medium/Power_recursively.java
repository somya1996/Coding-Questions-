package RECURSION.medium;

import java.util.Scanner;

public class Power_recursively {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int A , int B){
		if(A == 0)
			return 0;
		if(B == 0)
			return 1;
		int x = solve(A , B/2);
		if(B%2 == 0){
			return x*x;
		}
		else{
			return A*x*x;
		}
	}
}
