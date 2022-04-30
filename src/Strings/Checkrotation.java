package Strings;

import java.util.Scanner;
/*
INPUT:                                OUTPUT
geeksforgeeks                                TRUE
forgeeksgeeks

mightandmagic                                FALSE
andmagicmigth
*/
public class Checkrotation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		System.out.println(to_check(s1,s2));
	}
	public static boolean to_check(String s1 , String s2){
		String s = "";
		boolean flag = true;
		if(s1.length() != s2.length()) {
			return false;
		}
		/*else if(!s1.equals(s2))
			flag =  false;*/2
		if(s1.equals(s2))
			flag = true;
		else {
			int l = s1.length();
			for (int i = 1; i < s1.length(); i++) {
				s += s1.charAt(i-1);
				System.out.println(" s " + s);
				System.out.println(" substring of s1 " + s1.substring(i, l));
				String ans = s1.substring(i,l)+s;
				System.out.println(" ans "+ans);
				if (s2.equals(ans)) {
					return true;
				}
			}
		}
		return false;
	}
}
