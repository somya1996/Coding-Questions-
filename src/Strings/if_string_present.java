package Strings;

import java.util.Scanner;

public class if_string_present {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		int idx = a.indexOf(b);
		if(idx>=0)
			System.out.println("Present");
		else
			System.out.println("Not found");
	}
}

