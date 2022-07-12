package RECURSION.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Print_all_pallindrome_permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		HashSet<String> ans = new HashSet<String>();
		solve(str , 0 , str.length()-1 , ans);
		System.out.println(ans);
	}
	public static void solve(String str , int start , int end , HashSet<String> ans){
		// Base case
		if(start == end){
			if(isPallindrome(str)){
				ans.add(str);
			}
			return;
		}
		for(int i= start; i <= end ; i++){
			str = swap(str , start , i);
			solve(str , start+1 , end , ans);
			str = swap(str , start , i);
		}
	}
	public static String swap(String str , int i , int j){
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt( i , str.charAt(j));
		sb.setCharAt( j , str.charAt(i));
		return sb.toString();
	}
	public static boolean isPallindrome(String str){
		int start = 0 , end = str.length()-1;
		while(start < end){
			if(str.charAt(start) == str.charAt(end)){
				start++;
				end--;
			}
			else
				return false;
		}
		if(start == end)
			return true;
		return  false;

	}
}
