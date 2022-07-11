package RECURSION.medium;

import java.util.Scanner;

public class Target_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		findTargetSumWays(arr , target);
	}
	public static void findTargetSumWays(int[] nums, int target) {

	}
}
