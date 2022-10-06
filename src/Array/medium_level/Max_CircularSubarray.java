package Array.medium_level;

import java.util.Scanner;

public class Max_CircularSubarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = maxSubarraySumCircular(arr);
		System.out.println(ans);
	}
	public static int maxSubarraySumCircular(int[] nums) {
		int n = nums.length;
		if (n == 1)
			return nums[0];

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += nums[i];
		}

		int curr_max = nums[0], max_so_far = nums[0],
				curr_min = nums[0], min_so_far = nums[0];

		// Concept of Kadane's Algorithm
		for (int i = 1; i < n; i++){

			// Kadane's Algorithm to find Maximum subarray sum.
			curr_max = Math.max(curr_max + nums[i], nums[i]);
			max_so_far = Math.max(max_so_far, curr_max);

			// Kadane's Algorithm to find Minimum subarray sum.
			curr_min = Math.min(curr_min + nums[i], nums[i]);
			min_so_far = Math.min(min_so_far, curr_min);
		}
		if (min_so_far == sum) {
			return max_so_far;
		}

		// returning the maximum value
		return Math.max(max_so_far, sum - min_so_far);
	}
}
