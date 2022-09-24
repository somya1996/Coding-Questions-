package Stack.Hard;

import java.util.Scanner;
import java.util.Stack;

public class Min_Stack {
	static Stack<Integer> s1 = new Stack<>();
	static Stack<Integer> min = new Stack<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int operation = sc.nextInt();
		for(int i=0; i<operation; i++){
			int ch = sc.nextInt();
			if(ch == 1){
				int x = sc.nextInt();
				push(x);
			}
			else if(ch == 2)
				pop();
			else if(ch == 3)
				System.out.println(top());
			else
				System.out.println(getmin());
		}
	}
	public static void push(int x){
		if(min.isEmpty())
			min.push(x);
		if(min.peek()>x)
			min.push(x);
		s1.push(x);
	}
	public static void pop(){
		int x = s1.pop();
		if(x == min.peek())
			min.pop();
	}
	public static int top(){
		return s1.peek();
	}
	public static int getmin(){
		return min.peek();
	}
}
