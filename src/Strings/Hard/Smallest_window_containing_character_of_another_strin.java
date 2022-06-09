package Strings.Hard;

import java.util.HashMap;
import java.util.Scanner;

public class Smallest_window_containing_character_of_another_strin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();
		String ans = smallest_window(s , p);
		System.out.println(ans);
	}
	public static String smallest_window(String s , String p){
		HashMap<Character, Integer> hm = new HashMap<Character , Integer>();
		for(int i=0; i<p.length(); i++){
			if(hm.containsKey(p.charAt(i))){
				hm.put(p.charAt(i) , hm.get(p.charAt(i))+1);
			}
			else{
				hm.put(p.charAt(i), 1);
			}
		}
		System.out.println(hm);
		String ans = "-1";
		int len = Integer.MAX_VALUE;
		int count = hm.size();
		int l=0 , r=0;
		while(r < s.length()) {
			while (count > 0 && r < s.length()) {
				if (hm.containsKey(s.charAt(r))) {
					hm.put(s.charAt(r), hm.get(s.charAt(r)) - 1);
					if (hm.get(s.charAt(r)) == 0)
						count--;
				}
				r++;
			}
			if (count != 0) {
				return ans;
			}
			if (r - l < len) {
				len = r - l;
				ans = s.substring(l, r);
			}
			while (l < r && count <= 0) {
				if (hm.containsKey(s.charAt(l))) {
					hm.put(s.charAt(l), hm.get(s.charAt(l)) + 1);
					if (hm.get(s.charAt(l)) == 1)
						count++;
				}
				l++;
				if (count == 0 && r - l < len) {
					len = r - l;
					ans = s.substring(l, r);
				}
			}
		}
		return ans;
	}
}
