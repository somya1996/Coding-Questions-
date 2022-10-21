package Heap;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Maximum_array_sum_after_B_negations {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int B){
		PriorityQueue < Integer > pq = new PriorityQueue < > ();
		//Adding all element in pq
		for (int val: A) {
			pq.add(val);
		}
		//consuming B modifications on minimum value
		while (B > 0) {
			int minVal = pq.poll();
			System.out.println("minval "+minVal);
			pq.add(-1 * minVal);
			B--;
		}
		//finding sum
		int sum = 0;
		while (pq.size() > 0) {
			sum += pq.poll();
		}
		return sum;
	}
}
