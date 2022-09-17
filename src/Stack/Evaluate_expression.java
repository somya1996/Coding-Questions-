package Stack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Evaluate_expression {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> al = new ArrayList<>();
		int n = sc.nextInt();
		for(int i=0; i<n; i++){
			al.add(sc.next());
		}
		int ans = evalRPN(al);
		System.out.println(ans);

	}
	public static int evalRPN(ArrayList<String> A) {
		int length = A.size();
		if(length==1) return Integer.parseInt(A.get(0));  //Edge case if only one number is present
		Stack < Integer > stk = new Stack < > ();
		int result=0;
		for (int i = 0; i < length; i++) {
			if (A.get(i).equals("+") || A.get(i).equals("-") || A.get(i).equals("*") || A.get(i).equals("/")) {
				String operator = A.get(i);
				int b = stk.pop();
				int a = stk.pop();
				if (operator.equals("+")) result = a+b;
				else if (operator.equals("-")) result = a-b;
				else if (operator.equals("*")) result = a*b;
				else if (operator.equals("/")) result = a/b;
				stk.push(result);
			} else {
				int currElement = Integer.parseInt(A.get(i));
				stk.push(currElement);
			}
		}
		return result;
	}
}
