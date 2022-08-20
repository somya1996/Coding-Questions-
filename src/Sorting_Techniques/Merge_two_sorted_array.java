package Sorting_Techniques;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

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

		System.out.println(" size of Array B");
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
			System.out.print(ans[i]+" ");
		}
	}
	public int[] solve(final int[] A, final int[] B) {
		/*
		// Brute force using space
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

		/* using space
		// TC - O(n+m)  SC - O(n+m)
		int m = A.length + B.length;
		int ans[] = new int[m];
		int i = 0 , j = 0 , k = 0;
		while(i < A.length && j < B.length){
			if(A[i] < B[j]){
				ans[k++] = A[i++];
			}
			else{
				ans[k++] = B[j++];
			}
		}

		while(i < A.length){
			ans[k++] = A[i++];
		}

		while(j < B.length){
			ans[k++] = B[j++];
		}
		return ans;
		*/ // using space
		//TC : O( nlog(n) + mlog(m) )
		//SC : O(n)
		Map<Integer,Boolean> mp = new TreeMap<Integer,Boolean>();

		// Inserting values to a map.
		for(int i = 0; i < A.length; i++)
		{
			mp.put(A[i], true);
		}
		for(int i = 0;i < B.length; i++)
		{
			mp.put(B[i], true);
		}

		// Printing keys of the map.
		int freq[] = new int[A.length+B.length];
		int k = 0;
		for (Map.Entry<Integer,Boolean> m : mp.entrySet())
		{
			freq[k++] = m.getKey();
			//System.out.print(m.getKey() + " ");
		}
		return freq;
	}
}
