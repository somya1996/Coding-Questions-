package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Double_Character_Trouble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String ans = solve(s);
		System.out.println(ans);
	}
	public static String solve(String A) {
		Stack<Character> s = new Stack<>();
		for(int i=A.length()-1; i>=0; i--){
			char x = A.charAt(i);
			if(s.isEmpty())
				s.push(x);
			else if(!s.isEmpty() && s.peek() == x )
				s.pop();
			else
				s.push(x);
		}

		StringBuilder ans = new StringBuilder();
		while(!s.empty()){
			ans.append(s.peek());
			s.pop();
		}

		return ans.toString();
	}
}
/*
Stack<int []> Master = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!Master.isEmpty() && Master.peek()[0] == ch){
                Master.peek()[1]++;
            }
            else Master.push(new int[]{ch, 1});
            if(Master.peek()[1] == k) Master.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!Master.isEmpty()){
            int top[] = Master.pop();
            while(top[1] --> 0)
                sb.append((char)top[0]);
        }
        return sb.reverse().toString();
 */
