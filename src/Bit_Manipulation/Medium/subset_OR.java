package Bit_Manipulation.Medium;

import java.util.ArrayList;
import java.util.Scanner;

public class subset_OR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				al.add(sc.nextInt());
			}
		}
		int ans = subsetOR(al);
		System.out.println(ans);
	}
	static int subsetOR(ArrayList<Integer> a) {
		/*int n = a.length;
		int tatal_xor = 0;
		for( int i = 0 ; i < n ; i++){
			tatal_xor |= a[i];
		}
		int ans = helper(a , n , tatal_xor , 0);
		return ans;*/

		int n = a.size();
		int k = 0;
		// Calculate maximum OR.
		for(int i = 0; i < n ; i++){
			k |= a.get(i);
		}
		int ans = helper(a, n, k, 0);
		return ans;
	}
	/*public static int helper(int[] arr, int n , int target , int curr){
		if( n <= 0 )
			if(target == curr)
				return 0;
		else
			return 1000000000;
		int x = helper(arr , n-1 , target , curr);

		int y = 1 + helper(arr , n-1, target , curr|arr[n-1]);

		return Math.min (x , y);

	}*/
	static int helper(ArrayList<Integer> a, int n, int k, int curr) {
		// Base condition.
		if (n <= 0) {
			// If k = curr, we reached target OR.
			if (k == curr) {
				return 1;
			} else {
				// We return infinity.
				return 1000000000;
			}
		}
		// arr[n-1] not taken in considertion.
		int x = helper(a, n - 1, k, curr);
		// arr[n - 1] is taken into considereation.
		int y = 1 + helper(a, n - 1, k , curr | a.get(n - 1));
		// Return current result.
		return Math.min(x, y);
	}
}
