package Array;

import java.util.HashMap;
import java.util.Scanner;

public class Min_distance_between_similar_pairs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];

		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		int ans = maximumDistance(A);
		System.out.println(ans);
	}
	public static int maximumDistance(int[] A) {
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		int dist = Integer.MAX_VALUE;
		for (int i = 0; i < A.length; i++) {
			if (hm.containsKey(A[i])) {
				dist = Math.min(dist, i - hm.get(A[i]));
				hm.put(A[i], hm.get(A[i]) + 1);
			} else {
				hm.put(A[i], i);
			}
		}
		if (dist == Integer.MAX_VALUE)
			return -1;
		return dist;
	}
}
