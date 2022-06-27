package Stack;

import java.util.Stack;

public class Stacktest {
	public static void main(String[] args) {
		creating_stack_usingLL s = new creating_stack_usingLL();
		s.push(1);
		s.push(2);
		s.push(3);
		s.pop();
		s.push(4);

		// see all elements
		while(!s.empty()){
			int x = s.top();
			System.out.println(x);
			s.pop();
		}

		Stack<Integer> mystack = new Stack<Integer>();
		mystack.push(5);
		mystack.push(7);
		System.out.println(mystack.peek());
	}
}
