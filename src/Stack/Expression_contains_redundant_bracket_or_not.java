package Stack;

import java.util.Scanner;
import java.util.Stack;
/*
We iterate through the given expression and for each character in the expression
if the character is an open parenthesis ‘(‘ or any of the operators or operands, we push it to the stack.
If the character is close parenthesis ‘)’, then pop characters till matching open parenthesis ‘(‘ is found.
Now for redundancy two conditions will arise while popping.
	If immediate pop hits an open parenthesis ‘(‘, then we have found a duplicate parenthesis.
		For example, (((a+b))+c)

	If immediate pop doesn’t hit any operand(‘*’, ‘+’, ‘/’, ‘-‘) then it indicates the presence of
	unwanted brackets surrounded by expression.
		For instance, (a)+b contains unwanted () around a thus it is redundant.
 */
public class Expression_contains_redundant_bracket_or_not {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.println(s);
		//sc.nextLine();
		int ans = braces(s);
		if(ans==1)
			System.out.println("Redundant");
		else
			System.out.println("Not redundant");
	}
	public static int braces(String A) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<A.length(); i++){
			boolean flag = true;
			if(A.charAt(i) == ')'){
				int top = stack.peek();
				stack.pop();
				while(top != '('){
					if (top == '+' || top == '-' || top == '*' || top == '/') {
						flag = false;
					}
					top = stack.peek();
					stack.pop();
				}
				if(flag == true)
					return 1;
			}
			else{
				stack.push(A.charAt(i));
			}
		}
		return 0;
	}
}
