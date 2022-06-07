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
		char c[] = ans.toCharArray();
		int st = 0 , e = 0;
		while(st< c.length){
			while(e<c.length && c[e]!=' '){
				e++;
			}
			if(st < e){
				reverse_String(c , st , e-1);
			}
			st = e+1;
			e = st;
		}

		return String.valueOf(c).trim();
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
