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
		// Time Complexity - O(n)
		// Space Complexity - O(n)
		/*HashSet<Integer> hs = new HashSet<>();
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
		}*/
		/*
		1 > If any element in the array is even then, it can be made 0.
		    Split that element into two equal parts of A[i]/2 and A[i]/2.
		    XOR of two identical numbers is zero. (Therefore this strategy makes an element 0.)

		2 > If any element is odd.
			Split it in two-part: 1, A[i]-1.
			Since A[i]-1 is even, it can be made 0 by the above strategy.
			(Therefore an odd element can reduce its size to 1).

		3 > Two odd elements can be made 0 by following the above strategy (1)
		    1 XOR 1 = 0.

		4 > Therefore if the number of odd elements in the array is even, the answer is possible.
			Otherwise, an element of value 1 will be left, and it is impossible to satisfy the condition.
		 */
		int cnt = 0;
		for (int x: A) {
			if (x % 2 == 1)
				cnt++;
		}
		if (cnt % 2 == 1)
			return "No";
		else
			return "Yes";
	}
}
