package RECURSION.medium;

import java.util.Scanner;

public class Print_subsequence_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String curr = "";
		solve_subsequence(s , s.length() , 0 , curr);
	}
	public static void solve_subsequence(String s , int n , int idx , String curr){
		// time complexity - 2^n
		if(idx == n){
			System.out.print(curr+" ");
			return;
		}
		String op1 = curr ;// take element

		op1 += s.charAt(idx);
		solve_subsequence(s , n , idx+1 , op1);

		String op2 = curr ;// not take element
		solve_subsequence(s , n , idx+1 , op2);
	}
}
