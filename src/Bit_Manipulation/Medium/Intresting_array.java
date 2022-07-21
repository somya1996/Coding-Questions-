package Bit_Manipulation.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Intresting_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}
		String s = solve(a);
		System.out.println(s);
	}
	public static String solve(int[] A) {
		HashSet<Integer> hs = new HashSet<>();
		int xor = 0;
		for(int i=0; i<A.length; i++){
			xor ^= A[i];
		}
		while(true){
			if(xor == 0){
				return "yes";
			}
			if( xor == 1)
				return "No";

			if(hs.contains(xor)){
				return " NO ";
			}

			int a = xor;
			a = a/2;
			//System.out.println(" a "+a);
			int b = xor-a;
			//System.out.println(" b "+b);
			xor = a^b;
			hs.add(xor);
		}
	}
}
