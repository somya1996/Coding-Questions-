package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Search_an_element_in_sorted_and_rotated_Array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		int ans = search(arr , target);
		System.out.println(ans);
	}
	public static int search(final int[] A, int B) {
		int p = find_pivot(A , 0 , A.length-1);
		System.out.println(p);
		if(p == -1)
			return binarySearch(A , 0 , A.length-1 , B);
		if(A[p] == B)
			return p;
		if(A[0] <= B){
			return binarySearch(A , 0 , p-1 , B);
		}
		else{
			return binarySearch(A , p+1 , A.length-1, B);
		}
	}
	public static int find_pivot(int arr[] , int low , int high) {
		/*if (start > end)
			return -1;
		if (start == end)
			return start;
		int mid = (start + end) / 2;
		// special case where I found my pivot
		if (mid < end && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > start && arr[mid] < arr[mid - 1])
			return mid-1;

		// recursive case to find pivot
		if (arr[start] >= arr[mid])
			return find_pivot(arr, start, mid-1);
		//if(arr[start] > arr[mid])
		return find_pivot(arr, mid+1, end);*/

		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid+1;
		if (mid > low && arr[mid] < arr[mid - 1])
			return mid;
		if (arr[low] >= arr[mid])
			return find_pivot(arr, low, mid - 1);
		return find_pivot(arr, mid + 1, high);
	}
	public static int binarySearch(int[] arr , int start ,int end , int target){
		//base case
		if(end < start)
			return -1;
		int mid = (start+end)/2;
		// base case
		if(arr[mid] == target)
			return mid;
		if(arr[mid] < target)
			return binarySearch(arr , mid+1 , end , target);
		else
			return binarySearch(arr , start , mid-1, target);
	}
}
