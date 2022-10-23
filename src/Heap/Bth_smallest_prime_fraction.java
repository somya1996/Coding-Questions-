package Heap;

import groovy.lang.Tuple;

import java.util.*;

public class Bth_smallest_prime_fraction{
	public static class tuple{
		double div;
		int val1;
		int val2;
		tuple(double division , int val1 , int val2){
			div = division;
			this.val1 = val1;
			this.val2 = val2;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<A.length; i++){
			A[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		int[] ans = solve(A , B);
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
	/** BRUTE FORCE **/
	/**
	 * Make a tuple and store 3 values in a tuple
	        1> division  2> numerator 3> denominator
	 * Pushing all the tuples in priority queue and maintain it sorting by giving its element which is to be compared for sorting
	        PriorityQueue<tuple> pq = new PriorityQueue<tuple>(Comparator.comparing(x -> x.div));
	 * extract Bth element
	 **/
	/*
	public static int[] solve(int[] A, int B) {
		PriorityQueue<tuple> pq = new PriorityQueue<tuple>(Comparator.comparing(x -> x.div));
		for(int i=0; i<A.length; i++){
			for(int j=i+1; j<A.length; j++){
				tuple p = new tuple((double) A[i]/A[j] , A[i] , A[j]);
				pq.add(p);
			}
		}
		tuple t ;
		int x =0, y=0;
		while(B-->0){
			t = pq.poll();
			x = t.val1;
			y = t.val2;
			System.out.println(t.div);
			System.out.println(t.val1);
			System.out.println(t.val2);
		}
		int ans[] = new int[2];
		ans[0] = x;
		ans[1] = y;
		return ans;
	}
	*/
	/** OPTIMIZED APPROACH **/
	public static int[] solve(int A[] , int B) {
		/*PriorityQueue<tuple> pq = new PriorityQueue<>(Comparator.comparing(a->a.div));
		int last = A.length-1;
		for(int i=0; i<A.length; i++){
			pq.add(new tuple((double)(A[i]/A[last]) , i , last));
		}
		while(B-- > 0){
			tuple t = pq.poll();
			if(t.val2-1 > t.val1){
				pq.add(new tuple((double) (A[t.val1]/A[t.val2-1]) , t.val1 , t.val2-1));
			}
		}
		tuple a = pq.poll();
		return new int[]{A[a.val1],A[a.val2]};*/

		PriorityQueue<Double> min_heap = new PriorityQueue<Double>();
		HashMap<Double, int[]> map = new HashMap<>();
		int n = A.length;

		for (int i = 0; i < n - 1; i++) {
			double fraction = 1D * A[i] / A[n - 1];
			min_heap.add(fraction);
			map.put(fraction, new int[]{i, n - 1});
		}

		while (B != 1) {
			int[] temp = map.remove(min_heap.poll());
			if ((temp[1] - 1) > temp[0]) {
				double fraction = 1D * A[temp[0]] / A[temp[1] - 1];
				min_heap.add(fraction);
				map.put(fraction, new int[]{temp[0], temp[1] - 1});
			}
			B--;
		}

		int[] ans = map.get(min_heap.peek());
		return new int[]{A[ans[0]], A[ans[1]]};
	}
}
