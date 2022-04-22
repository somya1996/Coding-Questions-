package Array;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Make_array_non_increasing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
			arr[i] = sc.nextInt();

		int diff = 0 , sum = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for(int i=0;i<n;i++){
			if(!pq.isEmpty() && pq.element()<arr[i]){
				diff = arr[i] - pq.element();
				sum += diff;
				pq.remove();
			}
			pq.add(arr[i]);
		}
		System.out.println(sum);
	}
}
