package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Minimum_largest_element {
	class Pair{
		int value;
		int index;
		Pair(int val , int i){
			value = val;
			index = i;
		}
	}
	class CustomComp implements Comparator<Pair>{
		@Override
		public int compare(Pair a , Pair b) {
			return a.value - b.value;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		Minimum_largest_element mle = new Minimum_largest_element();
		int ans = mle.solve(A , B);
		System.out.println(ans);
	}
	public int solve (int A[] , int B){
		PriorityQueue<Pair>pq = new PriorityQueue<Pair>(new CustomComp());

		int new_state[] = new int[A.length];
		for(int i=0; i<A.length; i++){
			new_state[i] = A[i];
		}

		for(int i=0; i<A.length; i++){
			pq.offer(new Pair(A[i]*2 , i));
		}
		while(B-->0){
			Pair top = pq.poll();
			new_state[top.index] = top.value;
			pq.add(new Pair(A[top.index]+top.value , top.index));
		}
		int max = Integer.MIN_VALUE;
		for(int i=0; i<new_state.length; i++){
			max = Math.max(max , new_state[i]);
		}
		return max;
	}
}
/**
 * Let’s keep a state array to keep track of the value of every element in the array after K operations.
 * Maintain a state array, which tells about the state of the array after every operation.
 * Initially, the state array will be the same as the initial array.
 *
 * We need to consider the next state of every element in the array [it is doubling each element].
 * Consider a min-heap. And initially push the next state of every element in the heap.
 * Note that you need to keep track of the indices of every element in the heap, present in the initial array.
 * Pick the top element, and change the state of that element in the state array.
 * Pop this element and push the next state in the heap.
 * At every operation, we are choosing the element whose next state is minimum hence there are only two possibilities:
 * 1) Either the maximum element remains the same, and we return that element directly.
 * 2) The next state of the popped element is the maximum.
 * We made sure changing the state of this element is the best option, as the next state of this element is the minimum.
 * Hence the maximum will be the least using this approach.
 */