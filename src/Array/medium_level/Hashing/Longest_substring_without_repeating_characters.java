package Array.medium_level.Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class Longest_substring_without_repeating_characters {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int ans = lengthOfLongestSubstring(s);
		System.out.println(ans);
	}
	public static int lengthOfLongestSubstring(String s) {
		HashSet<Character> hs = new HashSet<>();
		int start = 0 , end = 0 , ans = Integer.MIN_VALUE;
		for(int i=0; i<s.length(); i++){
			if(hs.contains(s.charAt(i))){
				end = i;
				ans = Math.max(ans , end - start);
				start = end;
				hs.clear();
				hs.add(s.charAt(start));
			}
			else{
				hs.add(s.charAt(i));
			}
		}
		return ans;
	}
}
