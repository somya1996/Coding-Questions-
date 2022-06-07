package Strings;

import java.util.Scanner;

public class reverse_string_by_word {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = reverse(s);
		System.out.println(ans);
	}
	public static String reverse(String s){
		String ans = "";
		for(int i=s.length()-1; i>=0; i--){
			ans += s.charAt(i);
		}
		//System.out.println("ans :"+ans);
		char c[] = ans.toCharArray();
		/*for(int i=0; i<c.length; i++){
			System.out.print(c[i]);
		}*/
		//System.out.println();
		int st = 0 ;
		for (int e = 0; e < c.length; e++){
			if(c[e] == ' '){
				reverse_String(c , st , e-1);
				st = e+1;
			}
		}
		reverse_String(c , st , c.length-1);

		/*for(int i=0; i<c.length; i++){
			System.out.print(c[i]);
		}*/
		/*String fa = "";
		for(int i=0; i<c.length; i++){
			fa += c[i];
		}*/
		return String.valueOf(c);
	}
	public static void reverse_String(char[] c , int start , int end){
		while (start <= end){
			char temp = c[start];
			c[start] = c[end];
			c[end] = temp;
			start++;
			end--;
		}
	}
}
