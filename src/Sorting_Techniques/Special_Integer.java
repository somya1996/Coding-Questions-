package Sorting_Techniques;

import java.util.Arrays;
import java.util.Scanner;

public class Special_Integer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int B = sc.nextInt();
		// total subarray size k whose sum should be less than B
		System.out.println(solve(arr , B));
	}
	public static int solve(int[] A, int B) {
		//TC O(nlogn)
		int n = A.length;
		int sum = 0 , ans = n;
		int l = 0;
		for(int i=0; i<n; i++) {
			sum += A[i];
			System.out.println("i " + i+" sum "+sum);
			if (sum > B) {
				while (sum > B) {
					sum -= A[l];
					l++;
					System.out.println("l "+l+" sum "+sum);
					//if(ans > i-l+1)
					//	ans = i-l+1;
				}
				ans = Math.min(ans, i - l + 1);
				System.out.println("ans "+ans);
			}
		}
		if(sum == 0)
			return 0;
		//return Math.min(ans , n);
		return ans;
	}
}
