package Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Running_Median {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];

		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		Running_Median rm = new Running_Median();
		int ans[] = rm.solve(A);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public int[] solve(int[] A){
		PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
		PriorityQueue<Integer> minheap = new PriorityQueue<>();
		ArrayList<Integer> ans = new ArrayList<>();
		maxheap.add(A[0]);
		ans.add(A[0]);

		for(int i=1; i<A.length; i++){
			if(A[i] > maxheap.peek()){
				minheap.add(A[i]);
			}
			if(A[i] < maxheap.peek()){
				maxheap.add(A[i]);
			}

			if(maxheap.size() - minheap.size()>1){
				int val = maxheap.poll();
				minheap.add(val);
				//ans.add(maxheap.peek());
			}
			else if(maxheap.size() - minheap.size() <0){
				int val = minheap.poll();
				maxheap.add(val);
				//ans.add(minheap.peek());
			}

			ans.add(maxheap.peek());
		}
		int arr[] = new int[ans.size()];
		for(int i=0; i<ans.size(); i++){
			arr[i] = ans.get(i);
		}
		return arr;
	}
}
/**
 * If inserting each element in priority queue and finding median will take time complexity O(n2)

 * Optimization Idea: To insert the median in priority queue (imagination is let say in odd median is mid element so before
    the median all elements will be less than median and after median in an array all elements will be greater than )so
    1> max element from left side will be the median if size is odd
    2> max elememt + min element from right side will be mediam if size is even

 * will use two priority queue one is maxheap(stores all element that is less than median
    and other is minheap(stores all element that is greater than median)

 **/