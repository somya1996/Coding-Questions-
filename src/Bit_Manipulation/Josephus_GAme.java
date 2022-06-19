package Bit_Manipulation;

import java.util.Scanner;

public class Josephus_GAme {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int remaining = josephus(n);
		System.out.println(remaining);
	}
	public static int josephus(int n){
		int npo2 = po2(n); //nearest power of 2
		int killed = n - npo2;
		int remaining_person = 2*killed+1;
		return remaining_person;
	}
	public static int po2(int n){
		int x = 1;
		while((x*2)<=n)
			x = x*2;
		return x;
	}
}
