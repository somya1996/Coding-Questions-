package Array;

import java.util.Scanner;

public class Minimum_Value_to_Get_Positive_Step_by_Step_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(minStartValue(arr));
	}
	public static int minStartValue(int[] nums) {
		// brute force
		// TIME COMPLEXITY : O(n^2)
		// Space Complexity : O(1)
		/*int startValue = 1;

		// While we haven't found the first valid startValue
		while (true) {
			int total = startValue;
			boolean isValid = true;

			// Iterate over the array "nums".
			for (int num : nums) {
				total += num;
				if (total < 1) {
					isValid = false;
					break;
				}
			}

			if(isValid) {
				return startValue;
			}
			else {
				startValue ++;
			}
		}*/
		// Prefix sum
		// Time Complexity : O(n)
		// Space Complexity : O(1)
		int total = 0 , min = Integer.MAX_VALUE;
		for(int i=0; i<nums.length; i++){
			total += nums[i];
			min = Math.min(min ,  total);
		}
		return -min+1;
	}
}
