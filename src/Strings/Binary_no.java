package Strings;

import java.util.Scanner;

public class Binary_no {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(Binary_digit(n));
	}

	public static String Binary_digit(int n) {
		String s = "";
		String m[] = {"","M","MM","MMM"};
		String c[] = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
		String x[] = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
		String i[] = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
		String thousand = m[n/1000];
		String hundred = c[(n%1000)/100];
		String tens = x[(n%100)/10];
		String ones = i[(n%10)];
		s += thousand+hundred+tens+ones;
		return s;
	}
}
