package Array.medium_level;

import java.util.Scanner;

public class Kadanes_Algorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int max = maximum_subarray_sum(arr,n);
		System.out.println(max);
	}
	public static int maximum_subarray_sum(int arr[], int n){
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			if(max < sum )
				max = sum;
			if(sum < 0)
				sum = 0;
		}
		return max;
	}
}
