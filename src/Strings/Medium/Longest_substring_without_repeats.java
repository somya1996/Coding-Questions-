package Strings.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Longest_substring_without_repeats {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		int len = lengthOfLongestSubstring(A);
		System.out.println(len);
	}
	public static int lengthOfLongestSubstring(String A) {
		/*HashSet<Character>hs = new HashSet<>();
		int l = 0 , r = 0;
		int len = 0;
		while(r < A.length()){
			if(hs.contains(A.charAt(r))){
				while(l < r && hs.contains(A.charAt(r))){
					hs.remove(A.charAt(l));
					l++;
				}
			}
			hs.add(A.charAt(r));
			len = Math.max(len , hs.size());
			r++;
		}
		return len;*/
		if(A.length()==0 || A.length()==1)
			return A.length();
		HashMap<Character , Integer> hm = new HashMap<>();
		int start = 0 , end = 0 , ans = 0;
		while(end<A.length()){
			char c = A.charAt(end);
			if(hm.containsKey(c) && start<=hm.get(c)){
				start = hm.get(c)+1;
			}
			ans = Math.max(ans,end-start+1);
			hm.put(c,end);
			end++;
		}
		return ans;
	}
}
