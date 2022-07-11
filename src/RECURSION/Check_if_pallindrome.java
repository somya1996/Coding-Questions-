package RECURSION;

import java.util.Scanner;
// TC - O(N)
public class Check_if_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		/*if(is_pallindrome(0 ,s , s.length()-1))
			System.out.println(1);
		else
			System.out.println(0);
		*/
		System.out.println(is_pallindrome(0,s));
	}
	// parameterized recursion
	/*public static boolean is_pallindrome(int s , String str , int l){
		if(s>=l)
			return true;
		if(str.charAt(s) != str.charAt(l))
			return false;
		return is_pallindrome(s+1,str,l-1);
	}*/
	// functional recursion
	public static boolean is_pallindrome(int i , String str){
		int n = str.length()-1;
		if(i == str.length()/2)
			return true;
		if(str.charAt(i)!=str.charAt(n-i-1))
			return false;
		return is_pallindrome(i+1 , str);
	}
}
