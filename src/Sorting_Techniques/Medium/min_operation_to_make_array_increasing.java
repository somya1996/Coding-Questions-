package Sorting_Techniques.Medium;

import java.util.Scanner;

public class min_operation_to_make_array_increasing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i]  = sc.nextInt();
		}
		int ways = minOperations(arr);
		System.out.println(ways);
	}
	public static int minOperations(int[] nums) {
		if(nums.length == 1)
			return 0;
		int operation = 0;
		int previous = nums[0];
		for(int i=1; i<nums.length; i++){
			int current = nums[i];
			if(current <= previous){
				current = previous+1;
				operation += current - nums[i];
				nums[i] = current;
			}
			previous = nums[i] ;
		}
		return operation;
	}
}
