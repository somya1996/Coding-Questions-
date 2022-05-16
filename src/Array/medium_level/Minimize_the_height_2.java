package Array.medium_level;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array arr[] denoting heights of N towers and a positive integer K, you have to modify the height of
each tower either by increasing or decreasing them by K only once. After modifying, height should be a non-negative
integer.
Find out the minimum possible difference of the height of shortest and longest towers after you have modified
each tower.
You can find a slight modification of the problem here.
Note: It is compulsory to increase or decrease by K to each tower.
Example 1:
Input:                                 Output:
K = 2, N = 4                           5
Arr[] = {1, 5, 8, 10}

Explanation:
The array can be modified as {3, 3, 6, 8}. The difference between the largest and the smallest is 8-3 = 5.
*/
public class Minimize_the_height_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = getMinDiff(arr,n,k);
		System.out.println(ans);
	}
	public static int getMinDiff(int[] arr, int n, int k) {
		Arrays.sort(arr); // This is to see the distance between max element and min element (order is not necessary)
		int min = arr[0];
		int max = arr[n-1];
		int height = arr[n-1]-arr[0];

		for(int i=1; i<n; i++){  // Nou iterating each element and checking its max and min value to get the min height distance
			if(arr[i]-k <0 )
				continue;
			min = Math.min(arr[0]+k , arr[i]-k);
			max = Math.max(arr[n-1]-k , arr[i-1]+k);
			height = Math.min(height , max-min);
		}
		return height;
	}
}
