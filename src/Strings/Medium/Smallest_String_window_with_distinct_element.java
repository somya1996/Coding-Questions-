package Strings.Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Smallest_String_window_with_distinct_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int len = findSubString(str);
		System.out.println(len);
	}
	public static int findSubString( String str) {
		int minSubLength = str.length();
		int i=0,j=0;

		HashMap<Character, Integer> m = new HashMap<>();
		Set<Character> s = new HashSet<>();

		for(i = 0; i<str.length();i++)
		{
			s.add(str.charAt(i));
		}
		i=0;

		while(i<str.length()) {
			//First we extract all unique possible characters {condition: m.size()<s.size()}
			//Next we update count in map, and increment counter till all unique characters
			// achieved for given substring

			while (i < str.length() && m.size() < s.size()) {
				char ch = str.charAt(i);
				m.put(ch, m.getOrDefault(ch, 0) + 1);
				i++;
			}

			//Next up, we shrink window size, by keeping 'j' var till unique characters are still
			// being retained in map {condition: m.size()==s.size()}. Here, we perform check
			// for min. length substring and also decrease the count of characters in map accordingly.

			while (j < i && m.size() == s.size()) {
				char ch = str.charAt(j);

				minSubLength = Math.min((i - j), minSubLength);

				if (m.get(ch) == 1) {
					m.remove(ch);
				} else {
					m.put(ch, m.get(ch) - 1);
				}
				j++;
			}
		}
		return minSubLength;
	}
}
