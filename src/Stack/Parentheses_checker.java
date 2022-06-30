package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Parentheses_checker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		Parentheses_checker p = new Parentheses_checker();
		System.out.println(p.ispar(s)?true:false);
	}
	boolean ispar(String x){
		Stack<Character> s = new Stack<>();
		for(int i=0; i<x.length(); i++){
			if(x.charAt(i)=='['||x.charAt(i)=='('||x.charAt(i)=='{'){
				s.push(x.charAt(i));
			}
			else{
				if(!s.isEmpty()){
					int ch = s.peek();
					if(ch == '{' || x.charAt(i)=='}')
						s.pop();
					if(ch == '[' || x.charAt(i)==']')
						s.pop();
					if(ch == '(' || x.charAt(i)==')')
						s.pop();
				}
			}
		}
		if(s.isEmpty())
			return true;
		return false;
	}
}
