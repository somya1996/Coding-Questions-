package Strings;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.HashMap;

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
		/*int len1 = a.length();
		int len2 = b.length();
		if (len1 == len2) {
			char A[] = a.toLowerCase().toCharArray();
			char B[] = b.toLowerCase().toCharArray();
			if (Arrays.equals(A, B)) ;
			return true;

		}
		return false;*/
		a = a.toLowerCase();
		b = b.toLowerCase();
		HashMap<Character,Integer> hm1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> hm2 = new HashMap<Character,Integer>();
		int len1 = a.length();
		int len2 = b.length();
		if(len1!=len2)
			return false;
		for(int i=0;i<len1;i++){
			if(hm1.containsKey(a.charAt(i)))
				hm1.put(a.charAt(i),hm1.get(a.charAt(i)+1));
			else
				hm1.put(a.charAt(i),1);
		}
		for(int i=0;i<len2;i++){
			if(hm2.containsKey(b.charAt(i)))
				hm2.put(b.charAt(i),hm2.get(b.charAt(i)+1));
			else
				hm2.put(b.charAt(i),1);
		}
		if(hm1.equals(hm2))
			return true;
		return false;
	}
}
