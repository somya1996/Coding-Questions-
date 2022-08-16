package Sorting_Techniques;

import java.util.Scanner;

public class Binary_search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int target = sc.nextInt();
		int ans = Search(arr , target);
		System.out.println(ans);
	}
	public static int Search(int[] arr , int target){
		// using recursive way
		int start = 0 , end = arr.length-1;
		int ans = binarySearch(arr , 0 , arr.length-1 , target);
		//System.out.println(ans);
		return ans;
	}
	public static int binarySearch(int[] arr , int start , int end , int target){
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
