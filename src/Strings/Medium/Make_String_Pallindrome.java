package Strings.Medium;

import java.util.Scanner;

public class Make_String_Pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int ans = solve(A);
		System.out.println(ans);
	}
	public static int solve(String A){
		String ans = "";
		int len = 0;
		for(int i=0; i<A.length(); i++){
			ans = ans + A.charAt(i);
			if(isPallindrome(ans))
				len = ans.length();
		}
		int diff = A.length()-len;
		return diff;
	}
	public static boolean isPallindrome(String a){
		int i=0 , j = a.length()-1;
		while(i<j){
			if(a.charAt(i) != a.charAt(j)){
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
