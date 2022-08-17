package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Median_of_row_wise_sorted_matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][] arr = new int[R][C];

		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		int median = findMedian(arr);
		System.out.println(median);
	}
	public static int findMedian(int[][] A) {
		int low = 0 , high = 1000000000;
		int R = A.length ; int C = A[0].length;
		int midPos = (R*C)/2;
		while(low <= high) {
			int mid = (low + high) / 2;
			System.out.println("mid"+mid);
			int cnt = 0;
			//count the element less tha mid
			for(int i=0; i<R; i++){
				cnt += lowerBound(A[i] , mid);
				System.out.println(" cnt "+cnt);
			}
			if(cnt <= midPos){
				low = mid+1;
				System.out.println("low "+low);
			}
			else{
				high = mid-1;
				System.out.println("high "+high);
			}
		}
		return  low;
	}
	public static int lowerBound(int A[] , int target){
		int low = 0 , high = A.length-1;
		while(low <= high){
			int mid = (low+high)/2;
			if(A[mid] <= target)
				low = mid+1;
			else
				high = mid -1;
		}
		return low;
	}
}
