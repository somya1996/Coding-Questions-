package QUEUE;

import java.util.Stack;

public class implement_queue_using_stack {
	public static Stack<Integer> s1 = new Stack<>();
	public static Stack<Integer> s2 = new Stack<>();

	public static void main(String[] args) {
		push(3);
		push(4);
		System.out.println("The element poped is " + pop());
		push(5);
		System.out.println("The top element is " + peek());
		System.out.println("The size of the queue is " + size());
	}
	public static void push(int x){
		while(!s1.isEmpty()){
			s2.push(s1.pop());
		}
		s1.push(x);
		while(!s2.isEmpty()){
			s1.push(s2.pop());
		}
	}
	public static int pop(){
		if(!s1.isEmpty())
			return s1.pop();
		return -1;
	}
	public static int peek(){
		if(!s1.isEmpty())
			return s1.peek();
		return 0;
	}
	public static int size(){
		return s1.size();
	}
}
