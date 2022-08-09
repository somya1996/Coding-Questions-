package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Merge_two_sorted_Array_O_1_space {
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

		Merge_two_sorted_Array_O_1_space mts = new Merge_two_sorted_Array_O_1_space();
		// extra space is allowed
		mts.merge(A , B , A.length , B.length);

		for (int i=0; i<A.length; i++){
			System.out.print(A[i]+" ");
		}
		System.out.println();
		for (int i=0; i<B.length; i++){
			System.out.print(B[i]+" ");
		}
	}
	public static void merge(int arr1[], int arr2[], int n, int m){
		int mid = (n+m)/2;
		while(mid >= 1){
			int i=0 , j = mid;
			while(j < (n+m)) {
				if (i < n && j < n) {
					if (arr1[i] > arr1[j]) {
						int temp = arr1[i];
						arr1[i] = arr1[j];
						arr1[j] = temp;
					}
				} else if (i < n && j >= n) {
					if (arr1[i] > arr2[j - n]) {
						int temp = arr1[i];
						arr1[i] = arr2[j - n];
						arr2[j - n] = temp;
					}
				} else {
					if (arr2[i - n] > arr2[j - n]) {
						int temp = arr2[i - n];
						arr2[i - n] = arr2[j - n];
						arr2[j - n] = temp;
					}
				}
				i++;
				j++;
			}
			if(mid == 1)
				break;
			mid = (mid+1)/2;
		}
	}

}
