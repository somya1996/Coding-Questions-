package Strings;

import java.util.HashMap;
import java.util.Scanner;

public class Length_of_longest_sub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = longestUniqueSubsttr(s);
		System.out.println(ans);
	}
	public static int longestUniqueSubsttr(String s){
		int l = 0 , r = 0;
		int max = 0;
		int count = 0;
		HashMap<Character , Integer> hm = new HashMap<>();
		while(r < s.length()){
			if(hm.containsKey(s.charAt(r))){
				hm.put(s.charAt(r) , hm.get(s.charAt(r))+1);
				while(hm.get(s.charAt(l))>1) {
					hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
					l++;
				}
				max = Math.max(max , count);
			}
			else{
				hm.put(s.charAt(r),1);
				count++;
			}
			//max = Math.max(max , count);
			r++;
		}
		return max;
	}
}
