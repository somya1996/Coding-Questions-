package Strings;

import java.util.Scanner;

public class Find_kth_character_in_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		String b = Integer.toBinaryString(m);
		int i = 0;
		while (i < n) {
			String s = "";
			for (Character c : b.toCharArray()) {
				if (c == '1')
					s += "10";
				if(c == '0')
					s += "01";
			}
			b = s;
			i++;
		}
		char[] d = b.toCharArray();
		System.out.println(d[k-1]);
	}
}

