package Strings;

import java.util.ArrayList;
import java.util.HashMap;

public class String_Reversal {
	public static void main(String[] args) {
		String s = "I AM AWESOME";
		String ans = reverseString(s);
		//Don't print the space
		System.out.println(ans);
	}
	public static String reverseString(String s)
	{
		// without using extra space
		String rev ="";
		ArrayList<Character> al = new ArrayList<Character>();
		for(int i= s.length()-1; i>=0; i--){
			if(!al.contains(s.charAt(i))){
				al.add(s.charAt(i));
				rev += s.charAt((i));
			}
		}
		rev = rev.replace(" ","");
		return rev;


		//with using extra space
		/*String ans = "";
		String rev = "";
		String[] words = s.split(" ");
		for(int i=0; i<words.length; i++){
			StringBuilder s1 = new StringBuilder(words[i]);
			s1.reverse();
			rev += s1.toString();
		}
		System.out.println(rev);
		HashMap<Character , Integer> hm = new HashMap<>();
		for(int i=0; i<rev.length(); i++){
			if(hm.containsKey(rev.charAt(i)))
				hm.put(rev.charAt(i),hm.get(rev.charAt(i))+1);
			else {
				hm.put(rev.charAt(i), 1);
				ans += rev.charAt(i);
			}
		}
		return ans;*/


	}
}
