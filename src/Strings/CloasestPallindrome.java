package Strings;

import java.util.Scanner;

public class CloasestPallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String ans = solve(A);
		System.out.println(ans);
	}
	public static String solve(String A) {
		int i= 0 , j = A.length()-1;
		int count = 0;
		while(i<j){
			if(A.charAt(i)!=A.charAt(j)){
				count++;
			}
			i++;
			j--;
		}
		if(count == 0 && A.length() % 2 == 1)
			return "YES";
		if(count == 1)
			return "YES";
		return "NO";
	}
}
