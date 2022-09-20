package Stack.Hard;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Max_Area_Rectangle_Histogram {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer>al = new ArrayList<>();
		for(int i=0; i<n; i++){
			al.add(sc.nextInt());
		}
		int ans = solve(al);
		System.out.println(ans);
	}
	public static int solve(ArrayList<Integer> A) {
		Stack<Integer>st = new Stack<>();
		int left[] = new int[A.size()];

		for(int i=0; i<A.size(); i++){
			while(!st.isEmpty() && A.get(i)<=A.get(st.peek()))
				st.pop();
			if(st.isEmpty())
				left[i] = -1;
			else
				left[i] = st.peek();
			st.push(i);
		}

		for(int i=0;i<left.length; i++)
			System.out.print(left[i]+" ");
		System.out.println();

		Stack<Integer>st1 = new Stack<>();
		int right[] = new int[A.size()];
		//right[A.size()-1] = A.size();
		for(int i=A.size()-1; i>=0; i--){
			while(!st1.isEmpty() && A.get(i)<=A.get(st1.peek()))
				st1.pop();
			if(st1.isEmpty())
				right[i] = A.size();
			else
				right[i] = st1.peek();
			st1.push(i);
		}
		for(int i=0;i<right.length; i++)
			System.out.print(right[i]+" ");
		System.out.println();
		int max = 0;
		for(int i=0; i<A.size(); i++){
			int width = right[i]-left[i]-1;
			if(max < width*A.get(i)){
				max = width*A.get(i);
			}
		}
		return max;
	}
}


