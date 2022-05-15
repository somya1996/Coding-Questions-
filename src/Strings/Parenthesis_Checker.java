package Strings;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Parenthesis_Checker {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String x = sc.nextLine();
		if(isbalanced(x)== true)
			System.out.println(" Balanced ");
		else
			System.out.println(" Non Balanced ");
	}
	public static boolean isbalanced(String x){
		Stack<Character> s = new Stack<>();
		for(int i=0; i<x.length(); i++){
			if(x.charAt(i)=='('||x.charAt(i)=='{'||x.charAt(i)=='[')
				s.push(x.charAt(i));
			else{
				if(!s.empty()){
					char ch = s.peek();
					if((x.charAt(i)==')' && ch == '(') ||
						(x.charAt(i)=='}' && ch == '{')||
						(x.charAt(i)==']' && ch == '['))
						s.pop();
					else
						return false;
				}
				else{ // This is if stack is empty but closing brackets are there so it is not balanced
					return false;
				}
			}
		}
		if(s.empty())
			return true;
		return false;
	}
}
