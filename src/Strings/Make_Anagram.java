package Strings;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Make_Anagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int count = 0;

		/*HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for(int i=0; i<s1.length();i++){
			if(hm.containsKey(s1.charAt(i)))
				hm.put(s1.charAt(i), hm.get(s1.charAt(i)) + 1);
			else
				hm.put(s1.charAt(i),1);
		}
		System.out.println(" first "+hm);
		for(int i=0;i<s2.length();i++){
			if(hm.containsKey(s2.charAt(i)))
				hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
			else
				hm.put(s2.charAt(i),1);
		}
		System.out.println(" second "+hm);*/
		char c[] = new char[26];
		for(int i=0;i<s1.length();i++){
			c[s1.charAt(i)-'a']++;
		}
		for(int i=0;i<s2.length();i++){
			c[s2.charAt(i)-'a']--;
		}
		for(int i=0;i<c.length;i++){
			if(c[i]==1)
				count++;
		}
		System.out.println(count);
	}
}
