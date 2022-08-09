package Sorting_Techniques;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_two_sorted_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(" size of Array A");
		int n = sc.nextInt();
		int A[] = new int[n];
		System.out.println("Values should be sorted");
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		System.out.println(" size of Array A");
		int m = sc.nextInt();
		int B[] = new int[m];
		System.out.println("Values should be sorted");
		for(int i=0; i<m; i++){
			B[i] = sc.nextInt();
		}

		Merge_two_sorted_array mts = new Merge_two_sorted_array();
		// extra space is allowed
		int[] ans = mts.solve(A , B);

		for (int i=0; i<ans.length; i++){
			System.out.println(ans[i]);
		}
	}
	public int[] solve(final int[] A, final int[] B) {
		/*
		// Brute force
		int m = A.length + B.length;
		int ans[] = new int[m];
		int k = 0;
		for(int i=0; i<A.length; i++){
			ans[k++] = A[i];
		}
		for(int i=0; i<B.length; i++){
			ans[k++] = B[i];
		}
		// instead of this we use insertion sort , bubble sort , selection sort
		Arrays.sort(ans);
		return ans;

		*/
		int m = A.length + B.length;
		int ans[] = new int[m];

		return ans;
	}
}
