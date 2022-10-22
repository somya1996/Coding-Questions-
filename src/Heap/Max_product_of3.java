package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Max_product_of3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans[] = solve(A);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] solve(int[] A) {
		int ans[] = new int[A.length];
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		ans[0] = -1;
		pq.offer(A[0]);
		ans[1] = -1;
		pq.offer(A[1]);
		for(int i=0; i<A.length; i++){
			if(i<2)
				ans[i] = -1;
			else{
				pq.offer(A[i]);
				int prod = 0;
				int val1  = pq.poll();
				int val2 = pq.poll();
				int val3 = pq.poll();
				prod = val1*val2*val3;
				pq.offer(val1);
				pq.offer(val2);
				pq.offer(val3);
				ans[i] = prod;
			}
		}
		return ans;
	}
}
