package Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Misha_and_candies {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<A.length; i++){
			A[i] = sc.nextInt();
		}
		System.out.println("B value");
		int B = sc.nextInt();
		int ans = solve(A , B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int B) {
		PriorityQueue<Integer>pq = new PriorityQueue<>();
		for(int x:A){
			pq.add(x);
		}
		int sum = 0;
		while(pq.size()>0){
			int val1 = pq.poll();
			if(val1 > B)
				return sum;
			sum += val1/2;
			if(pq.size()>0) {
				int val2 = pq.poll();
				val2 += val1 - val1/2;
				pq.add(val2);
			}
		}
		return sum;
	}
}
