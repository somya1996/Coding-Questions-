package Bit_Manipulation;

import java.util.Scanner;

public class Non_repeating_Numbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0;i<n; i++){
			arr[i] = sc.nextInt();
		}
		int[] ans = singleNumber(arr);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+" ");
	}
	public static int[] singleNumber(int[] nums){
		int ans[] = new int[2];
		int xor = 0;
		for(int k : nums){
			xor ^= k;
		}
		int rmsb = xor & (-xor);
		int a = 0 , b = 0;
		for(int k: nums){
			if((rmsb&k)==1){
				a ^= k;
			}
			else{
				b ^= k;
			}
		}
		if(a<b){
			ans[0] = a;
			ans[1] = b;
		}
		else{
			ans[0] = b;
			ans[1] = a;
		}
		return ans;
	}
}
