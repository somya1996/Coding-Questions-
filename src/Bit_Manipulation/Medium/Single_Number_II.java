package Bit_Manipulation.Medium;

import java.util.Scanner;

public class Single_Number_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<arr.length; i++)
			arr[i] = sc.nextInt();
		int ans = singleNumber(arr);
		System.out.println(ans);
	}
	public static int singleNumber(int[] nums) {
		int ans = 0;
		for(int i=0; i<32; i++){
			int sum = 0;
			for(int j=0; j<nums.length; j++){
				if((nums[j] & (1<<i)) != 0){
					sum++;
				}
			}
			if(sum%3 != 0){
				ans |= 1<<i;
			}
		}
		return ans;
	}
}
