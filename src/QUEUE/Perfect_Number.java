package QUEUE;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Perfect_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		String ans = solve(A);
		System.out.println(ans);
	}
	public static String solve(int A) {
		Queue<String> q = new LinkedList<>();
		q.add("11");
		q.add("22");
		int cnt = 2;
		ArrayList<String> al = new ArrayList<String>();
		while(al.size() < A){
			String x = q.peek();
			//System.out.println("x "+x);
			al.add(x);
			q.remove(x);
			if(cnt >= A)
				continue;
			else{
				int mid = x.length()/2;
				String a = x.substring(0,mid);
				//System.out.println(a);
				String b = x.substring(mid);
				//System.out.println(b);
				q.add(a+"11"+b);
				q.add(a+"22"+b);
				cnt += 2;
			}
		}
		return al.get(al.size()-1);
	}
}
