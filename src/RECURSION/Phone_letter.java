package RECURSION;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Phone_letter {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String digit = sc.nextLine();
		ArrayList<String> ans = letterCombinations(digit);
		System.out.println(ans);
	}
	public static ArrayList<String> letterCombinations(String digits){
		ArrayList<String> ans = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		HashMap<Integer, String> hm = new HashMap<Integer , String >();
		hm.put(0,"0");
		hm.put(1,"1");
		hm.put(2,"abc");
		hm.put(3,"def");
		hm.put(4,"ghi");
		hm.put(5,"jkl");
		hm.put(6,"mno");
		hm.put(7,"pqrs");
		hm.put(8,"tuv");
		hm.put(9,"wxyz");
		letter_Combination(digits , ans , temp , hm);
		return ans;
	}
	public static void letter_Combination(String digits , ArrayList<String>ans , ArrayList<String>temp ,
	                                      HashMap<Integer,String>hm){
		if(digits.isEmpty()){
			ans.add("");
			return;
		}
		int x = digits.charAt(0)-'0';
		String remaining = digits.substring(1);
		temp = letterCombinations(remaining);
		String pattern = hm.get(x);
		for(int i=0; i<pattern.length(); i++){
			char ch = pattern.charAt(i);
			for(String t : temp){
				ans.add(ch+t);
			}
		}
	}
}
