package Array.medium_level;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class min_sliding_window_of_string {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String p = sc.nextLine();
		String ans = smallestWindow(s , p);
		System.out.println(ans);
	}
	public static String smallestWindow(String s, String p){
		HashMap<Character , Integer> hm = new HashMap< Character , Integer >();
		// This is for string p that how many characters we need to check
		for(int i=0; i<p.length(); i++){
			if(hm.containsKey(p.charAt(i))){
				hm.put(p.charAt(i), hm.get(p.charAt(i))+1);
			}
			else{
				hm.put(p.charAt(i), 1);
			}
		}
		String ans = "-1";
		int len = Integer.MAX_VALUE;
		int count = hm.size(); // size of string p
		//Traversing the sliding window
		int l = 0 , r = 0;
		// first we initialize right and then itereate it to check the window
		while(r < s.length()) {
			// run till count is not zero that means we didnt get the whole string p (reduce the frequency if char found)
			while (count > 0 && r < s.length()) {
				if (hm.containsKey(s.charAt(r))) {
					hm.put(s.charAt(r), hm.get(s.charAt(r)) - 1);
					if (hm.get(s.charAt(r)) == 0)
						count--;
					}
				r++;
			}
			if(count!=0)
				return ans;
			if(r-l<len){
				len = r-l;
				ans = s.substring(l,r);
			}

			// Now we w l<rill check if we can reduce the string by removing unwanted characters
			while( l<r  &&  count == 0 ){
				if(hm.containsKey(s.charAt(l))){
					hm.put(s.charAt(l), hm.get(s.charAt(l)) + 1);
					if(hm.get(s.charAt(l))== 1)
						count++;
				}
				l++;
				if(count == 0 && r-l < len){
					len = r-l ;
					ans = s.substring(l , r);
				}
			}
		}
		return ans;
	}
}
