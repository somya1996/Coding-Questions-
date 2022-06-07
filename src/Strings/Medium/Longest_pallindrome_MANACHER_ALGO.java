package Strings.Medium;

import java.util.Scanner;

public class Longest_pallindrome_MANACHER_ALGO {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = longest_Pallindrome(s);
		System.out.println(ans);
	}
	public static String longest_Pallindrome(String s){
		String ans = "";
		// for odd length pallindrome
		for(int i=0; i<s.length(); i++){
			int p1 = i , p2 = i;
			String n = expand(s , p1 , p2 );
			if(ans.length()<n.length()){
				ans = n;
			}
		}
		// for even length pallindrome
		for(int i=0; i<s.length(); i++){
			int p1 = i , p2 = i+1;
			String e = expand(s , p1 , p2);
			if(ans.length()<e.length()){
				ans = e;
			}
		}
		return ans;
	}
	public static String expand(String s , int p1 , int p2){
		while(p1>=0 && p2<=s.length()-1 && s.charAt(p1) == s.charAt(p2)){
			p1--;
			p2++;
		}
		return s.substring(p1+1 , p2);
	}
}
