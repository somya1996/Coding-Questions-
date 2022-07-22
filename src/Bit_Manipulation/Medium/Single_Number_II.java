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

		int[] freq = new int[32];

		for(int x: nums){
			int k = 0;
			int p = x;
			while(p !=0) {
				int last_Bit = (p & 1);
				if (last_Bit == 1) {
					freq[k]++;
				}
				k++;
				p = p>>1;
			}
		}
		for(int i=0; i<freq.length; i++){
			System.out.print(freq[i]+" ");
		}
		int ans = 0;
		int mul = 1;
		for(int i=0; i<32; i++){
			ans += freq[i]%3 * mul;
			mul = mul<<1;
		}
		return ans;

		// one way
		/*int ans = 0;
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
*/

		// other way

	}
}
