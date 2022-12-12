package Array.Hard_level;

import java.util.Scanner;

public class Next_permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		Next_permutation np = new Next_permutation();
		np.nextPermutation(arr);

		for(int i=0; i<n; i++) {
			System.out.println(arr[i]);
		}
	}
	private void nextPermutation(int[] nums){
		int i = nums.length - 2;
		while (i >= 0 && nums[i + 1] <= nums[i]) {
			i--;
		}

		if (i >= 0) {
			int j = nums.length - 1;
			while (nums[j] <= nums[i]) {
				j--;
			}
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}


	private void reverse(int[] nums, int start) {
		int i = start, j = nums.length - 1;
		while (i < j) {
			swap(nums, i, j);
			i++;
			j--;
		}
	}


	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
