package Dynamic_programming;

import java.util.Scanner;

public class Maximum_Product_Subarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		int ans = maxProduct(arr);
		System.out.println(ans);
	}

	public static int maxProduct(final int[] A) {
		int maxval = A[0];
		int minval = A[0];
		int prod = A[0];
		for(int i=1; i<A.length; i++) {
			if (A[i] < 0) {
				int temp = minval;
				minval = maxval;
				maxval = temp;
			}
			minval = Math.min(A[i], minval * A[i]);
			maxval = Math.max(A[i], maxval * A[i]);
			prod = Math.max(prod , maxval);
		}
		return prod;
	}

}
