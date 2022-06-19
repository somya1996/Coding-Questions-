package Bit_Manipulation;

import java.util.Scanner;

public class josephus_Game2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int remaining = josephus2(n , k);
		System.out.println(remaining);
	}
	public static int josephus2(int n , int k){
		if(n == 1)
			return 0;
		int x = josephus2(n-1,k); // assuming 0 to n
		int y = (x+k)%n; // to get the actual value
		return y;
	}
}
