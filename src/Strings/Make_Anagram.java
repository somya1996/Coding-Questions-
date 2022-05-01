package Strings;
import java.util.*;

public class Make_Anagram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		int count = 0;

		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
		for (int i = 0; i < s1.length(); i++) {
			if (hm.containsKey(s1.charAt(i)))
				hm.put(s1.charAt(i), hm.get(s1.charAt(i)) + 1);
			else
				hm.put(s1.charAt(i), 1);
		}
		System.out.println(" first " + hm);
		for (int i = 0; i < s2.length(); i++) {
			if (hm.containsKey(s2.charAt(i))) {

				hm.put(s2.charAt(i), hm.get(s2.charAt(i)) - 1);
			}
			else {
				hm.put(s2.charAt(i), -1);
			}
		}
		System.out.println(" second " + hm);
		/*for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
			if (entry.getValue()<0 || entry.getValue()==1)
				count+= entry.getValue();
		}*/
		for(int i: hm.values())
		{
			if(i<0) {
				count = count - i;
				System.out.println(" i less : "+i+" "+count);
			}
			else {
				count = count + i;
				System.out.println(" i greater : "+i+" "+count);
			}
		}

		System.out.println(count);
	}
}
