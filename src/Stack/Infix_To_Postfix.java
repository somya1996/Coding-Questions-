package Stack;

import javax.xml.transform.sax.SAXResult;
import java.util.Scanner;
import java.util.Stack;
//Input : a+b*(c^d-e)^(f+g*h)-i
public class Infix_To_Postfix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = solve(s);
		System.out.println(ans);
	}
	public static String solve(String A){
		Stack<String> alpha = new Stack<>();
		Stack<Character> opr = new Stack<>();
		for(int i=0; i<A.length(); i++){
			char ch = A.charAt(i);
			if(ch == '(') {
				opr.push(ch);
				System.out.println("operand stack "+opr.size());
			}
			else if((ch>='a' && ch<='z')||(ch>='A'&&ch<='Z')||(ch>='0'&&ch<='9')){
				alpha.push(ch+"");
				System.out.println(" alphabet stack "+alpha.size());
			}
			else if(ch == ')'){
				while(opr.peek() != '(' && opr.size()>0){
					char val = opr.pop();
					String v2 = alpha.pop();
					String v1 = alpha.pop();
					String new_str = v1+v2+val;
					alpha.push(new_str);
				}
				opr.pop();
				System.out.println("ch = ) "+alpha.size()+" "+opr.size());
			}
			else if((ch=='*')||(ch=='/')||(ch=='%')||(ch=='+')||(ch=='-')||(ch == '^')){
				while(opr.size()>0 && precedence(opr.peek()) >= precedence(ch) && opr.peek()!='('){
					char val = opr.pop();
					String v2 = alpha.pop();
					String v1 = alpha.pop();
					String new_str = v1+v2+val;
					alpha.push(new_str);
				}
				opr.push(ch);
			}
		}
		while(opr.size() > 0) {
			char val = opr.pop();
			String v2 = alpha.pop();
			String v1 = alpha.pop();
			String new_str = v1 + v2 + val;
			alpha.push(new_str);
		}
		return alpha.peek();
	}
	public static int precedence(char ch){
		if(ch == '+' || ch == '-')
			return 1;
		else if(ch == '*' || ch == '/' || ch == '%')
			return 2;
		else if(ch == '^')
			return 3;
		else
			return 0;
	}
}

