package Strings;

import java.util.Scanner;

public class Multiply_two_strings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		String y = sc.nextLine();
		String ans = multiplyStrings(x,y);
		System.out.println(ans);
	}
	public static String multiplyStrings(String s1,String s2){
		String pro = "";
		int num1 = 0 , num2 = 0;
		for(int i=0; i<s1.length(); i++){
			num1 = num1*10 + s1.charAt(i);
		}
		for(int i=0; i<s2.length(); i++){
			num2 = num2*10 + s2.charAt(i);
		}
		long product = num1*num2;

		return pro;
	}
}
