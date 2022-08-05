package RECURSION;

import java.util.Scanner;

public class reverse_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = "";
		int n = s.length()-1;
		String val = solve( s , ans , n);
		System.out.println(val);
	}
	public static String solve(String s , String ans , int n){
		if(n == 0){
			ans += s.charAt(n);
			return ans;
		}
		ans += s.charAt(n);
		return solve(s , ans , n-1);
	}
	/*
	public static void solve(String s){
        if(s.length() == 0){
            return;
        }
        solve(s.substring(1));
        System.out.print(s.charAt(0));
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        String str = cin.nextLine();
        solve(str);
    }
	 */
}
