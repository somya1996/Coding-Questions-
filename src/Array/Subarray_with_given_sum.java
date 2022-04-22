package Array;

import  java.util.Scanner;

public class Subarray_with_given_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		subArraySum(arr, n, k);
	}

	public static void subArraySum(int[] arr, int n, int k) {
		int sum, i, j;
		for (i = 0; i < n; i++) {
			sum = arr[i];
			//System.out.println("To check arr[i] "+arr[i]);
			for (j = i+1; j < n; j++) {
				sum +=  arr[j];
				//System.out.println("To check arr[j] "+arr[j]);
				if (sum == k)
					System.out.println(arr[i] + " to " + arr[j]);
			}
		}
	}
}
