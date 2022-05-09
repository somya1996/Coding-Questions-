package Array.medium_level.prefix_sum;

import java.util.Arrays;
import java.util.Scanner;

/*
Maximum subarray size, such that all subarrays of that size have sum less than k

Examples :

Input :  arr[] = {1, 2, 3, 4} and k = 8.
Output : 2
Sum of subarrays of size 1: 1, 2, 3, 4.
Sum of subarrays of size 2: 3, 5, 7.
Sum of subarrays of size 3: 6, 9.
Sum of subarrays of size 4: 10.
So, maximum subarray size such that all subarrays of that size have the sum of elements less than 8 is 2.

Input :  arr[] = {1, 2, 10, 4} and k = 8.
Output : -1
There is an array element with value greater than k, so subarray sum cannot be less than k.

Input :  arr[] = {1, 2, 10, 4} and K = 14
Output : 2
*/
public class Max_subarray_size_have_sum_less_than_k {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<A.length; i++){
			A[i] = sc.nextInt();
		}
		int x = sc.nextInt();

		//prefix sum
		int ps[] = new int[A.length+1];
		Arrays.fill(ps,0);

		//ps[0] = A[0];

		for(int i=0 ; i<n ; i++){
			System.out.println(ps[i]);
			ps[i+1] = ps[i]+A[i];

		}
		for(int i=0; i<ps.length; i++) {
			System.out.print(ps[i] + " ");
		}

		System.out.println();

		int ans = maximum_size_subarray_less_then_x(ps , n , x);
		System.out.println(ans);
	}
	public static int maximum_size_subarray_less_then_x( int ps[] , int n, int x){
		int ans = -1;
		int start = 0 , end = n ;
		while(start<end){
			int mid = (start+end)/2;
			int i;
			for(i=mid; i<=n; i++){
				if(ps[i]-ps[i-mid]>x)
					break;
			}
			if(i==n+1){
				start = mid+1;
				ans = mid;
			}
			else
				end = mid-1;

		}
		return ans;
	}
}
