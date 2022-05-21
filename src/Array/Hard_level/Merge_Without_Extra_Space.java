package Array.Hard_level;

import java.util.Arrays;
import java.util.Scanner;

public class Merge_Without_Extra_Space {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for (int i=0; i<n; i++)
			A[i] = sc.nextInt();

		int m = sc.nextInt();
		int B[] = new int[m];
		for(int j=0; j<m; j++)
			B[j] = sc.nextInt();

		merge(A , B , n , m);

		for (int i=0; i<n; i++)
			System.out.print(A[i]+" ");

		System.out.println();

		for(int j=0; j<m; j++)
			System.out.print(B[j]+" ");
	}
	/*public static void merge(int arr1[], int arr2[], int n, int m) {
		int i = 0 , j = 0;
		while(i< arr1.length && j<arr2.length){
			if(arr1[i]>arr2[j]) {
				int temp = arr1[i];
				arr1[i] = arr2[j];
				arr2[j] = temp;
				i++;
			}
			if(arr2[j] > arr2[j-1])
				Arrays.sort(arr2);
		}
	}*/
	public static void merge(int arr1[], int arr2[], int n, int m) {
		// lets assume arr1 and arr2 the one whole array
		int mid = (n+m+1)/2;
		while(mid >= 1) { // if mid is 1 the (mid+1)/2 will always give 1 so we need to put break statement
			int i = 0 , j = mid;
			while (j < n + m) {
				if(i <n && j < n) {
					if (arr1[i] > arr1[j]) {
						int temp = arr1[i];
						arr1[i] = arr2[j];
						arr2[j] = temp;
					}
				}
				else if (i < n && j >= n) {
					if(arr2[j - n ] < arr1[i]){
						int temp = arr2[j-n];
						arr2[j-n] = arr1[i];
						arr1[i] = temp;
					}
				}
				else{
					if(arr1[i-n] > arr2[j-n]){
						int temp = arr1[i-n];
						arr1[i-n] = arr2[j-n];
						arr2[j-n] = temp;
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
