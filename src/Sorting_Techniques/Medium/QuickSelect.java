package Sorting_Techniques.Medium;

import java.util.Scanner;

import static Sorting_Techniques.Medium.Quick_sort.partition;

public class QuickSelect {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		System.out.println(solve(arr , k));

		for(int i=0; i<n; i++)
			System.out.print(arr[i]+" ");
	}

	public static int solve(int[] arr , int k) {
		int s = 0 , e = arr.length-1;
		int ans = quick_select(arr , s , e , k);
		return ans;
	}

	public static int quick_select(int[] arr, int s, int e, int k) {
		int p = partition(arr, s, e);
		if (p == k - 1)
			return arr[p];
		if (p < k - 1)
			return quick_select(arr, p + 1, e, k);
		else
			return quick_select(arr, s, p - 1, k);
	}
	public static int partition(int[] arr , int start , int end){
		int pivot = arr[end], j = start-1;
		for (int i = start; i <= end; i++) {
			if (arr[i] < pivot) {
				j++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		// swapping pivot to the final pivot location
		int temp = arr[end];
		arr[end] = arr[j+1];
		arr[j+1] = temp;

		return j+1;
	}
}
