package Bit_Manipulation;

import java.util.Scanner;

public class two_integers_that_appear_only_once {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int[] ans = solve(arr);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] solve(int[] A) {
		int total_xor = 0;
		for(int x : A){
			total_xor ^= x;
		}
		// first we do total xor in this the elements that are duplicate that got 0 and we get remaining
		// elements that are single.

		int last_bit = total_xor & (-total_xor);
		// Then we find that last bit which is 1 : ( * in XOR 1 only comes when 1 bit is 1 and 2nd bit is 0)
		// so we find the right most last bit that is 1 ;(USING MASKING)
		int last_bit0 = 0;
		int last_bit1 = 0;
		// Now we use & with all the elements
		// whose last bit is 1 xor them and get the unique element
		// whose last bit is 0 xir them and get the unique element
		for(int val : A){
			if((val & last_bit) == 0){
				last_bit0 ^= val;
			}
			else{
				last_bit1 ^= val;
			}
		}
		int arr[] = new int[2];
		if(last_bit0 < last_bit1){
			arr[0] = last_bit0;
			arr[1] = last_bit1;
		}
		else{
			arr[0] = last_bit1;
			arr[1] = last_bit0;
		}
		return arr;
	}
}
