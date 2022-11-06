package RECURSION.medium;

import java.util.*;

public class Remove_invalid_parenthesis {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		Remove_invalid_parenthesis ri = new Remove_invalid_parenthesis();
		ArrayList<String> ans = ri.solve(str);
		System.out.println(ans);
	}
	public ArrayList<String> solve(String A) {
		int min_removal_possible = getMin(A);
		ArrayList<String> ans = new ArrayList<>();
		possible_parenthesis(A , min_removal_possible , ans , new HashSet<String>());
		return ans;
	}
	public void possible_parenthesis(String A , int mr , ArrayList<String>ans , HashSet<String>hs){
		if(mr == 0){
			int min_removal_now = getMin(A);
			if(min_removal_now == 0) {
				if (!hs.contains(A)) {
					ans.add(new String(A));
					hs.add(A);
				}
			}
			return;
		}
		for(int i=0; i<A.length(); i++){
			String left = A.substring(0 , i);
			String right = A.substring(i+1);
			String total = left+right;
			possible_parenthesis(total , mr-1 , ans , hs);
		}
	}
	public int getMin(String A){
		Stack<Character> stk = new Stack<>();
		for(int i=0; i<A.length(); i++){
			char ch = A.charAt(i);
			//System.out.println(ch);
			if(ch == '('){
				stk.push(ch);
			}
			else if(ch == ')'){
				if(stk.size()==0)
					stk.push(ch);
				else if(stk.peek()== ')')
					stk.push(ch);
				else if(stk.peek() == '(')
					stk.pop();
			}
		}
		return stk.size();
	}
}
