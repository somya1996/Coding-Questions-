package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Median_of_two_Sorted_Array_Naive_approach {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for(int i=0; i< arr.length; i++)
			arr[i] = sc.nextInt();

		int m = sc.nextInt();
		int brr[] = new int[m];
		for(int i=0; i<m; i++){
			brr[i] = sc.nextInt();
		}

		double median = findMedianSortedArrays(arr , brr);
		System.out.println(median);
	}
	public static double findMedianSortedArrays(final int[] A, final int[] B) {
		// Brute force - using extra space
		// TC = O(n+m)log(n+m)  SC = O(n+m)
		/*
		int new_arr[] = new int[A.length+ B.length];
		int n = new_arr.length;
		int k = 0;
		for(int i=0; i<A.length; i++){
			new_arr[k++] = A[i];
		}
		for(int i=0; i<B.length; i++){
			new_arr[k++] = B[i];
		}
		Arrays.sort(new_arr);

		for(int i=0; i<n; i++){
			System.out.print(new_arr[i]+" ");
		}

		if(n %2 != 0){
			return new_arr[n/2];
		}
		else{
			return (new_arr[(n-1)/2]+new_arr[n/2])/2.0;
		}
		*/
		// Efficient Brute-force - without using extra space
		// TC - O(n+m) SC- O(1)
		int n = A.length , m = B.length;
		int total = A.length+B.length;
		int val1 = -1 , val2 = -1;
		int i = 0 , j = 0;
		// if odd all element
		if(total%2 == 1) {
			for (int count = 0; count <= total / 2; count++) {
				if(i!=n && j!=m){
					val1 = (A[i] < B[j])?A[i++]:B[j++];
				}
				else if(i<n)
					val1 = A[i++];
				else
					val1 = B[j++];
			}
			return val1;
		}
		else{
			for (int count = 0; count <= total / 2; count++) {
				val2 = val1;
				if(i!=n && j!=m){
					val1 = (A[i] < B[j])?A[i++]:B[j++];
				}
				else if(i<n)
					val1 = A[i++];
				else
					val1 = B[j++];
			}
			return (val1+val2)/2.0;
		}
	}
}
