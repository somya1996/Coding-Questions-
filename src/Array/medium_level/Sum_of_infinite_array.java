package Array.medium_level;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Sum_of_infinite_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int L = sc.nextInt();
		int R = sc.nextInt();

		int ans = sumInRanges(arr , n , L , R);
		System.out.println(ans);
	}
	public static int sumInRanges(int[] arr, int N, int L , int R) {
		// Stores the prefix sum
		int prefix[] = new int[N+1];
		prefix[0] = 0;

		// Calculate the prefix sum
		for (int i = 1; i <= N; i++) {
			prefix[i] = prefix[i - 1]
					+ arr[i - 1];
		}

		// Stores the sum of elements
		// from 1 to L-1
		int leftsum
				= ((L - 1) / N) * prefix[N]
				+ prefix[(L - 1) % N];

		// Stores the sum of elements
		// from 1 to R
		int rightsum = (R / N) * prefix[N]
				+ prefix[R % N];

		return rightsum - leftsum;
	}
}
