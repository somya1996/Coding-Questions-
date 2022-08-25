package Array.medium_level.Two_Pointer_Approach;

import java.util.Scanner;

public class Subarray_with_given_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int t = sc.nextInt();
		int ans[] = solve(arr , t);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int[] A, int B) {
		long n = A.length;
		int l = 0, r = 0;
		long sum = A[l];
		while (r < n) {
			if (sum == B) {
				int[] ans = new int[r - l + 1];
				for (int i = l; i <= r; i++) ans[i - l] = A[i];
				return ans;
			} else if (sum < B) {
				r++;
				if (r < n) sum += A[r];
			} else {
				sum -= A[l];
				l++;
				if (l > r && l < n - 1) {
					r++;
					sum += A[r];
				}
			}
		}
		int ans[] = new int[1];
		ans[0] = -1;
		return ans;
	}
}
