package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Min_Stack {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int q = sc.nextInt();
			Min_Stack m = new Min_Stack();
			while(q>0){
				int qt = sc.nextInt();
				if(qt == 1){
					int val = sc.nextInt();
					m.push(val);
				}
				else if(qt == 2){
					m.pop();
				}
				else if(qt == 3){
					System.out.print(m.top()+" ");
				}
				else if(qt == 4){
					System.out.print(m.getMin()+" ");
				}
				q--;
			}
			System.out.println();
			t--;
		}
	}
	int minEle;
	Stack<Integer> s = new Stack<Integer>();
	private int top() {
		if(s.isEmpty())
			return -1;
		int t = s.peek();
		if(t < 0)
			return minEle;
		else
			return t;
	}

	int getMin(){
		if(s.isEmpty()){
			return -1;
		}
		return minEle;
	}
	void push(int val){
		if(s.isEmpty()){
			minEle = val;
			s.push(val);
		}
		if(val >= minEle){
			s.push(val);
		}
		else if( val < minEle){
			s.push(val - minEle);
			minEle = val;
		}
	}
	void pop() {
		if (s.isEmpty())
			return;
		else {
			int t = s.pop();
			if (t < 0) {
				minEle = minEle - t;
			}
		}
	}
}
