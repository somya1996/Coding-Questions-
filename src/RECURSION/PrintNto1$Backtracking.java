package RECURSION;

import java.util.Scanner;

public class PrintNto1$Backtracking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		callingNto1(n);
	}
	public static int callingNto1(int n){
		if(n == 0)
			return 0;
		System.out.print(n +" ");
		return callingNto1(n-1);
	}
}
