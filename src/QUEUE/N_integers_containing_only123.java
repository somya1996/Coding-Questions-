package QUEUE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_integers_containing_only123 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = solve(n);
		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
	}
	public static int[] solve(int A) {
		Queue<Integer> q = new LinkedList<>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		int cnt = 3;
		while(al.size() < A){
			int x = q.peek();
			al.add(x);
			q.remove(x);
			if(cnt >= A)
				continue;
			else{
				q.add(10*x+1);
				q.add(10*x+2);
				q.add(10*x+3);
				cnt+=3;
			}
		}
		int ans[] = new int[A];
		for(int i=0; i<A; i++){
			ans[i] = al.get(i);
		}
		return ans;
	}
}
