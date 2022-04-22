package Strings;

import java.util.Scanner;
/*
String txt = "GeeksforGeekseeks";
String pat = "eeks";
output 3
 */
public class Frequency_of_substring {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String txt = sc.nextLine();
		String pat = sc.nextLine();
		int T = txt.length();
		int P = pat.length();
		int res = 0;
		for(int i=0; i<=T-P; i++){
			int j;
			for(j=0; j<P; j++){
				if(txt.charAt(i+j) != pat.charAt(j))
					break;
			}
			if(j==P)
				res++;
		}
		System.out.println(res);
	}
}
