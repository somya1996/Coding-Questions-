package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Connect_ropes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("size");
		int n = sc.nextInt();
		int A[] = new int[n];
		System.out.println("Elements of A");
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		Connect_ropes cr = new Connect_ropes();
		int sum = cr.solve(A);
		System.out.println(sum);
	}
	public int solve(int[] A) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<A.length; i++){
			pq.add(A[i]);
		}
		int sum = 0;
		int totalsum = 0;
		while(pq.size() >= 2){
			sum = 0;
			int val1 = pq.poll();
			int val2 = pq.poll();
			sum = val1+val2;
			totalsum += sum;
			pq.add(sum);
		}
		if(pq.size()>1)
			totalsum += pq.poll();
		return totalsum;
	}
}
