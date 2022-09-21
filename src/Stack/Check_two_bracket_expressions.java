package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Check_two_bracket_expressions{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String A = sc.nextLine();
		String B = sc.nextLine();
		if(solve(A , B)==1)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	public static int solve(String A, String B) {
		int[] freqA = new int[26];
		int[] freqB = new int[26];

		expand_string(A,freqA);
		expand_string(B,freqB);

		for(int i=0; i<26; i++){
			if(freqA[i] != freqB[i])
				return 0;
		}
		return 1;
	}
	public static void expand_string(String A, int[] freqA)
	{
		Stack<Boolean> stackA = new Stack<Boolean>();
		stackA.push(true);
		for(int i=0; i<A.length(); i++)
		{
			char ch = A.charAt(i);
			if(i!=0 && ch == '(')
			{
				char ch1 = A.charAt(i-1);
				if(ch1 == '-')
				{
					if(stackA.peek())
						stackA.push(false);
					else
						stackA.push(true);
				}
				else
				{
					if(stackA.peek())
						stackA.push(true);
					else
						stackA.push(false);
				}
			}
			else if(ch == ')')
				stackA.pop();

			else if(i==0 && ch>=97 && ch<=122)
				freqA[ch-'a'] = 1;

			else if(ch>=97 && ch<=122)
			{
				char ch1 = A.charAt(i-1);
				if(ch1 == '-')
				{
					if(!stackA.peek())
						freqA[ch-'a'] = 1;
				}
				else
				{
					if(stackA.peek())
						freqA[ch-'a'] = 1;
				}
			}
		}
	/*public static void expand_string(String A , int[]freqA){
		Stack<Boolean> stk = new Stack<>();
		stk.push(true);
		int i = 0;
		while(i < A.length()){
			char ch = A.charAt(i);
			if(ch == '+' || ch == '-') {
				i++;
				continue;
			}
			if(ch == '('){
				if(adj_sign(A , i)) {//TRUE
					if (stk.peek())//TRUE
						stk.push(stk.peek());
					else
						stk.push(!stk.peek());
				}
				else{//FALSE
					if(!stk.peek())//FALSE
						stk.push(stk.peek());
					else
						stk.push(!stk.peek());
				}
			}
			if(ch == ')')
				stk.pop();
			if(ch >= 'a' && ch <= 'z'){
				if(adj_sign(A,i)){
					if(stk.peek())
						freqA[ch-'a'] = 1;
					else
						freqA[ch-'a'] = -1;
				}
				else{
					if(!stk.peek())
						freqA[ch-'a'] = 1;
					else
						freqA[ch-'a'] = -1;
				}
			}
			i++;
		}
	}
	public static boolean adj_sign(String s , int i){
		if(i ==  0)
			return true;
		else{
			char ch = s.charAt(i-1);
			if(ch == '-')
				return false;
		}
		return true;*/
	}
}
