package RECURSION.medium;

import java.util.Scanner;

public class Permutation_with_spaces {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String op = "";
		op += s.charAt(0);
		//s = s.substring(1);
		//System.out.println(op);
		//System.out.println(s);
		solve(1 , s , op);
	}
	public static void solve(int idx , String s , String curr){
		// base case
		if(idx == s.length()){
			System.out.println(curr);
			return;
		}
		String op1 = curr ;
		op1 += " "+ s.charAt(idx);
		solve(idx+1 , s , op1);

		String op2 = curr;
		op2 += s.charAt(idx);
		solve(idx+1 , s , op2);
	}
}
