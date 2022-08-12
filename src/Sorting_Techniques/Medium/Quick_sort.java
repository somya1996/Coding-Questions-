package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Quick_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		quick_sort(arr , 0 , arr.length-1);

		for(int i=0; i<n; i++){
			System.out.print(arr[i]+" ");;
		}
	}
	public static void quick_sort(int[] arr , int start , int end){
		if(start >= end)
			return;
		int p = partition(arr , start , end);
		quick_sort(arr , start , p-1);
		quick_sort(arr , p+1 , end);
	}
	public static int partition(int[] arr , int start , int end){
		int pivot = arr[end];
		int i = start - 1;
		for(int j = start; j < end; j++){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[end];
		arr[end] = arr[i+1];
		arr[i+1] = temp;
		return i+1;
	}
}
