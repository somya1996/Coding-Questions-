package RECURSION;

import java.util.Scanner;

public class Print1toN$Backtracking {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		calling1toN(n);
	}
	public static int calling1toN(int n){
		if(n == 0)
			return 0;
		calling1toN(n-1);
		System.out.print(n +" ");
		return 0;
	}
}
