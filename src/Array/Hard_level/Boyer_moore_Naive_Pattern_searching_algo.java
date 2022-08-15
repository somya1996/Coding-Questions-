package Array.Hard_level;

import java.util.ArrayList;
import java.util.Scanner;

public class Boyer_moore_Naive_Pattern_searching_algo {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		ArrayList<Integer> ans = patternSearch(text , pattern);
		System.out.println(ans);
	}
	public static ArrayList<Integer> patternSearch(String text, String pattern) {
		ArrayList<Integer> result = new ArrayList<>();
		if(text.length() < pattern.length()) {
			result.add(-1);
			return result;
		}
		int n = text.length();
		int m = pattern.length();
		int i;
		for(i=0; i<=n-m; i++){
			int j;
			for(j=0; j<m; j++){
				if(text.charAt(i+j) != pattern.charAt(j)){
					break;
				}
			}
			if(j == m)
				result.add(i);
		}

		if(result.isEmpty()){
			result.add(-1);
			return result;
		}
		return  result;
	}
}
