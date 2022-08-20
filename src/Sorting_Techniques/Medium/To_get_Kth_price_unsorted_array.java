package Sorting_Techniques.Medium;

import java.util.Scanner;

public class To_get_Kth_price_unsorted_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int price[] = new int[n];
		for(int i=0; i<n; i++){
			price[i] = sc.nextInt();
		}
		int index = sc.nextInt();
		System.out.println(solve(price , index));
	}
	public static int solve(final int[] A, int B) {
		int max = Integer.MIN_VALUE , min = Integer.MIN_VALUE;
		int ans = -1;
		for(int i=0; i<A.length; i++){
			max = Math.max(max , A[i]);
			min = Math.min(min , A[i]);
		}
		int start = min , end = max;
		while(start <= end){
			int mid = (start + end)/2;
			int number = count(A , mid);
			if( number >= B){
				ans = mid;
				end = mid -1;
			}
			else{
				start = mid+1;
			}
		}
		return ans;
	}
	public static int count(int[] a , int mid){
		int num = 0;
		for(int i=0; i< a.length; i++){
			if(a[i]<= mid)
				num++;
		}
		return num;
	}
}
