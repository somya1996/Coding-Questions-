package RECURSION;

import java.util.Scanner;

public class Print1toN$parameterized {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		calling1toN(1,n);
	}
	public static int calling1toN(int i , int N){
		if(i > N){
			return 0;
		}
		System.out.print(i+" ");
		return calling1toN(i+1 , N);
	}
}
