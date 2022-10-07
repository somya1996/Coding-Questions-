package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Lexicographically_smallest_string {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		//sc.nextLine();
		int k = sc.nextInt();
		String ans = lexicographicallySmallest(s , k);
		System.out.println(ans);
	}
	public static String lexicographicallySmallest(String S, int k) {
		int n = S.length();
		// check power of 2
		if(powerOf2(S.length()))
			k = k/2;
		else
			k = 2*k;
		if(k>=n) return "-1";
		System.out.println(" k "+k);
		//StringBuilder s = new StringBuilder();
		String s = "";
		Stack<Character> st = new Stack<Character>();
		for(int i=0; i<S.length(); i++){
			while( k > 0 && !st.isEmpty() && S.charAt(i) < st.peek()){
				st.pop();
				k--;
			}
			st.push(S.charAt(i));
		}
		while(k>0 && !st.empty()){
			st.pop();
			k--;
		}
		while(!st.isEmpty()){
			//s.append(st.pop());
			s = st.pop()+s;
		}
		//return s.toString();
		return s;

	}
	public static boolean powerOf2(int k){
        if(k!=0 && (k&(k-1)) == 0)
            return true;
        return false;
	}
}
