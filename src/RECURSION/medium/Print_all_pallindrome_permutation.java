package RECURSION.medium;


import java.util.HashSet;
import java.util.Scanner;
/*
TIME COMPLEXITY
For any given string of length n there are n! possible permutations,
and we need to print all of them so Time complexity is O(n * n!).

SPACE COMPLEXITY
The function will be called recursively and will be stored in call stack for all n! permutations,
 so Space complexity is O(n!).
 */
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
			//System.out.println(str);
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
		int i = 0, j = str.length() - 1;
		while (i < j) {
			if (str.charAt(i) != str.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
