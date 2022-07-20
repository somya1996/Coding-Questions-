package Array;

import java.util.Scanner;

/*
Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)].
It is allowed to swap any two elements (not necessarily consecutive).

Find the minimum number of swaps required to sort the array in ascending order.
*/
public class Min_Swap_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		System.out.println(solve(arr));
	}
	public static int solve(int[] A) {
		int count = 0;
		for(int i=0 ; i < A.length; i++){
			int element = A[i];
			int pos = element;
			if(A[i] >= 0 && element < A.length ) {
				if (A[pos] != element) {

					int temp = A[i];
					A[i] = A[element];
					A[element] = temp;

					count++;
					i--;
				}
			}
		}
		return count;
	}
}
