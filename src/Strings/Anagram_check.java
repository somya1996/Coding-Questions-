package Strings;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram_check {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		if(isAnagram(a,b))
			System.out.println("Yes");
		else
			System.out.println("No");

	}
	public static boolean isAnagram(String a , String b) {
		int len1 = a.length();
		int len2 = b.length();
		if (len1 == len2) {
			char A[] = a.toLowerCase().toCharArray();
			char B[] = b.toLowerCase().toCharArray();
			if (Arrays.equals(A, B)) ;
			return true;

		}
		return false;
	}
}
