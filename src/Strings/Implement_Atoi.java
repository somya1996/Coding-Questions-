package Strings;

import java.util.Scanner;

public class Implement_Atoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		System.out.println(atoi(x));
	}
	public static int atoi(String s) {
		int num = 0 , flag = 0;
		for(int i=0; i<s.length(); i++) {
			if (s.charAt(0) == '-' && flag ==0 ) {
				flag = 1;
			}
			else if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				return -1;
			}
			else{

				num = num*10 + s.charAt(i)-'0';
			}
		}
		if(flag == 1)
			return -num;
		return num;
	}
}
