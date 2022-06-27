package Bit_Manipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Onrs_complement_of_Num {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = ones_complement(n);
		System.out.println(x);

	}
	public static int ones_complement(int n){
		ArrayList<Integer> al = new ArrayList<>();
		while(n!=0){
			al.add(n%2);
			n = n/2;
		}

		Collections.reverse(al);
		// change 1's to 0 and 0's to 1
		for (int i = 0; i < al.size(); i++) {
			if (al.get(i) == 0)
				al.set(i , 1);
			else
				al.set(i , 0);
		}
		// convert back to number representation
		int two = 1;
		for (int i = al.size() - 1; i >= 0; i--) {
			n = n + al.get(i) * two;
			two = two * 2;
		}
		return n;
	}
}
