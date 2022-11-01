package Greedy_Algorithm;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Mice_and_hole{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B[] = new int[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}
		int ans = mice(A , B);
		System.out.println(ans);
	}
	public static int mice(int[] A, int[] B) {
		PriorityQueue<Integer> mice = new PriorityQueue<>();
		PriorityQueue<Integer> hole = new PriorityQueue<>();
		for(int i=0; i<A.length; i++){
			mice.add(A[i]);
		}
		for(int j=0; j<B.length; j++){
			hole.add(B[j]);
		}
		int max_diff = 0;
		while(!mice.isEmpty()){
			int a = mice.poll();
			int b = hole.poll();
			int diff = Math.abs(a-b);
			max_diff = Math.max(max_diff , diff);
		}
		return max_diff;
	}
}
