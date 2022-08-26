package Array.medium_level.Two_Pointer_Approach;

import java.util.Scanner;

public class Closest_pair_from_sorted_arrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		int B[] = new int[m];
		for(int i=0; i<m; i++){
			B[i] = sc.nextInt();
		}

		int C = sc.nextInt();
		int[] ans = solve(A , B , C);
		for(int i=0; i<2; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int[] A, int[] B, int C) {
		int i = 0 , j = B.length-1;
		int result[] = new int[2];
		int ans = Integer.MAX_VALUE;
		while(i < A.length && j >= 0){
			int sum = A[i]+B[j];
			int diff = Math.abs(C - sum);
			if(diff == ans && A[i] == result[0])
				result[1] = B[j];
			if(diff < ans){
				ans = diff;
				result[0] = A[i];
				result[1] = B[j];

			}
			if(sum < C)
				i++;
			else
				j--;
		}
		return result;
	}
}
