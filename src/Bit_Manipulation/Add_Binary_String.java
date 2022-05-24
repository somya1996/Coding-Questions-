package Bit_Manipulation;

import java.util.Scanner;

public class Add_Binary_String {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();

		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		int sum = 0;
		String res = "";
		while(carry>0 || i >= 0 || j >= 0) {
			// 1+1 = 10  ( 1 carry)
			int x = (i < 0) ? 0:Character.getNumericValue(a.charAt(i));
			int y = (j < 0) ? 0:Character.getNumericValue(b.charAt(j));
			sum = carry + x + y;
			System.out.println(" x " + x + " y " + y + " sum " + sum);
			res = (sum % 2) + res;
			carry = sum / 2;
			i--;
			j--;
		}

		System.out.println(res);
	}
}
