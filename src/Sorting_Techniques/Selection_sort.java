package Sorting_Techniques;

import java.util.Scanner;

public class Selection_sort {
	public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			selection_sort(arr , n);
			System.out.println("After sorting ");
			for(int i=0; i<n; i++){
				System.out.print(arr[i]+" ");
			}
	}
	public static int[] selection_sort(int[]arr , int n){
		for(int i=0; i<n-1; i++){
			int min_idx = i;
			for(int j = i+1; j<n; j++) {
				if (arr[j] < arr[min_idx])
					min_idx = j;
			}
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
}
