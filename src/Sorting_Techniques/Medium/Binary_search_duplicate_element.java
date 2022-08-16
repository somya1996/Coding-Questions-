package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Binary_search_duplicate_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int target = sc.nextInt();

		int ans = duplicate_binary_search(arr , 0 , n , target);
		System.out.println(ans);
	}
	public static int duplicate_binary_search(int[] arr , int start , int end , int target){
		int ans = -1;
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] == target) {
				ans = mid;
				end = mid-1;
			}
			if(arr[mid] < target)
				start = mid+1;
			else
				end = mid-1;
		}
		return ans;
	}
}
