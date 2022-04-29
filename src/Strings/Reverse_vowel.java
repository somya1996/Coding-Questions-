package Strings;

import java.util.Scanner;
/*
input :   Practice
output :  Prectica
 */
public class Reverse_vowel {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char c[] = str.toCharArray();
		int j = 0;
		String vowel = "";
		for(int i=0;i< c.length;i++){
			if(isvowel(c[i])){
				j++;
				vowel += c[i];
			}
		}
		System.out.println(vowel);
		for(int i=0;i< c.length;i++){
			if(isvowel(c[i])){
				c[i] = vowel.charAt(--j);
			}
		}
		// convert char to string
		System.out.println(String.valueOf(c));
	}
	public static boolean isvowel(char c){
		return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
	}
}
