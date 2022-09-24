package QUEUE;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class sliding_window_maximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int ans[] = slidingMaximum(arr , B);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+" ");
	}
	public static int[] slidingMaximum(final int[] A, int B) {
		Deque<Integer> dq = new LinkedList<>();
		ArrayList<Integer> al = new ArrayList<>();
		// here we have added first k elements in deque and put the max element on the front
		for(int i=0; i<B; i++){
			while(!dq.isEmpty() && A[i]>=A[dq.peekLast()])
				dq.removeLast();
			dq.addLast(i);
		}
		System.out.println(dq);
		// from k to last element
		for(int i = B ; i<A.length ; i++){
			al.add(A[dq.peekFirst()]);
			System.out.println("al "+al);
			// remove elements from front whose indices are outside window
			while(!dq.isEmpty() && dq.peekFirst()<= i - B){
				dq.removeFirst();
			}
			// remove if last element is smaller than current element
			while(!dq.isEmpty() && A[dq.peekLast()] <= A[i])
				dq.removeLast();
			// now add current element in the last
			dq.addLast(i);
		}
		al.add(A[dq.peekFirst()]);
		int arr[] = new int[al.size()];
		for(int i=0; i<al.size(); i++){
			arr[i] =  al.get(i);
		}
		return arr;
	}
}
