package Sorting_Techniques.Medium;

import java.util.Scanner;

public class frequency_of_target_using_binary_search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();

		int ans = find_frequency(arr , target);
		System.out.println(ans);
	}
	public static int find_frequency(int[] arr , int target){
		int start = 0 , end = arr.length-1 ;
		int ending = -1 , starting = -1;
		while(start <= end){
			int mid = (start+end)/2;
			if(arr[mid] == target){
				starting = mid;
				end = mid - 1;
			}
			if(arr[mid] < target){
				start = mid+1;
			}
			else{
				end = mid -1;
			}
		}
		System.out.println(starting);
		int start1 = 0 ;
		int end1 = arr.length-1;
		while(start1 <= end1){
			int mid1 = (start1+end1)/2;
			if(arr[mid1] == target){
				ending = mid1;
				start1 = mid1 + 1;
			}
			if(arr[mid1] <= target){
				start1 = mid1+1;
			}
			else{
				end1 = mid1 -1;
			}
		}
		System.out.println(ending);

		return ending-starting+1;
	}
}
