package QUEUE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class First_non_repeating_character {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = solve(A);
		System.out.println(B);
	}
	public static String solve(String A) {

		Queue < Character > q = new LinkedList < Character > ();
		HashMap < Character, Integer > hm = new HashMap < Character, Integer > ();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < A.length(); i++){
			char c = A.charAt(i);
			if(hm.get(c) != null){
				hm.put(c , 2);
			}else{
				q.add(c);
				hm.put(c, 1);
			}
			while (q.size() > 0 && hm.get(q.peek()) > 1) {
				q.remove();
			}
			if (q.size() > 0)
				sb.append(q.peek());
			else
				sb.append('#');
		}
		return sb.toString();


		/*Queue < Character > q = new LinkedList < Character > ();
		HashMap < Character, Integer > mp = new HashMap < Character, Integer > ();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < A.length(); i++) {
			char c = A.charAt(i);
			if (mp.get(c) != null) {
				mp.put(c, 2);
			} else {
				q.add(c);
				mp.put(c, 1);
			}
			while (q.size() > 0 && mp.get(q.peek()) > 1) {
				q.remove();
			}
			if (q.size() > 0)
				sb.append(q.peek());
			else
				sb.append('#');
		}
		return sb.toString();*/
	}
}
