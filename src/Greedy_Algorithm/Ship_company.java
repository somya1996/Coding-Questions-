package Greedy_Algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Collections;

public class Ship_company {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C[] = new int[B];
		for(int i=0; i<B; i++){
			C[i] = sc.nextInt();
		}
		int[]ans = solve(A , B , C);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int A, int B, int[] C) {
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0; i<B; i++){
			minheap.add(C[i]);
		}
		for(int i=0; i<B; i++){
			maxheap.add(C[i]);
		}
		//for min cost
		int mincost = 0;
		int person = A;
		while(person > 0){
			mincost += minheap.peek();
			int val = minheap.poll();
			val = val-1;
			if(val>0)
				minheap.add(val);
			person--;
		}
		// for maximum cost
		int maxcost = 0;
		while(A>0){
			maxcost += maxheap.peek();
			int val = maxheap.poll();
			val = val-1;
			if(val>0)
				maxheap.add(val);
			A--;
		}

		return new int[]{maxcost , mincost};
	}
}
