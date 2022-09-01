package Sorting_Techniques.Medium;

import java.util.Scanner;

/*
5
45 10 15 25 50
 */
public class Reverse_pair {
	static int inCount = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		solve(arr);
		System.out.println(inCount);

		System.out.println();

		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");;
		}
	}
	public static int solve(int[] A) {
		mergeSort(A, 0, A.length-1);
		return (int) (inCount%1000000007);
	}
	static void mergeSort(int[] A, int s, int e) {
		if(s>=e)
			return;
		int m = (s+e)/2;
		mergeSort(A, s, m);
		mergeSort(A, m+1, e);
		merge(A, s, m, e);
	}
	static void merge(int[] arr, int s, int m, int e) {
		int[] L = new int[m-s+1];
		int[] R = new int[e-m];
		int i=0,j=0,k=s;
		while(i<L.length) {
			L[i]=arr[s+i];
			i++;
		}
		i=0;
		while(i<R.length) {
			R[i]=arr[m+i+1];
			i++;
		}
		i=0;
		while(i<L.length && j<R.length) {
			// Before merging the array count the reverse pairs
			long l1 = L[i];
			long l2 = R[j];
			if(L[i]>2*l2) {
				inCount += L.length-i;
				j++;
			} else
				i++;
		}
		i=0;
		j=0;
		while(i<L.length && j<R.length) {
			if(L[i]>R[j]) {
				arr[k++]=R[j++];
			} else {
				arr[k++]=L[i++];
			}
		}
		while(i<L.length)
			arr[k++] = L[i++];

		while(j<R.length)
			arr[k++]=R[j++];
	}
}
