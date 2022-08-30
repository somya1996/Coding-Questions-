package Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class Duplicate_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		solve(s);
	}
	public static void solve(String str){
		int count[] = new int[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			count[val]++;
		}

		for (int i = 0; i < 256; i++)
			if (count[i] > 1)
				System.out.println((char)(i) +
						", count = " + count[i]);
	}
}
