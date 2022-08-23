package Sorting_Techniques.Medium;

import java.util.Scanner;

public class kth_element_of_two_sorted_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];

		int m = sc.nextInt();
		int[] arr2 = new int[m];

		int k = sc.nextInt();
		long element = kthElement(arr1 , arr2 , n , m , k);
		System.out.println(element);
	}
	public static long kthElement( int arr1[], int arr2[], int n, int m, int k) {
		long min = arr1[0]<arr2[0]?arr1[0]:arr2[0];
		long max = arr1[n-1]<arr2[m-1]?arr2[m-1]:arr1[n-1];

		long ans = max;
		long start = min , end = max;
		while(start <= end){
			long mid = (start+end)/2;
			long count_element = count(arr1 , 0 , n , mid);
			count_element += count(arr2 , 0 , m , mid);
			if(count_element >= k){
				ans = mid;
				end = mid - 1;
			}
			if(count_element < k){
				start = mid + 1;
			}
		}
		return ans;
	}
	public static long count(int[] a , int low , int high, long mid){
		while(low < high){
			int middle = low + (high - low)/2;
			if(a[middle] > mid)
				high = middle;
			else
				low = middle + 1;
		}
		return low;
	}
}
