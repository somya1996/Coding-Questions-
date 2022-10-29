package Greedy_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Candie_Distribution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = candy(A);
		System.out.println(ans);
	}
	public static int candy(int[] A) {
		int n = A.length;
		int sum = 0;
		int[] ans = new int[n];
		if (n == 1){
			return 1;
		}

		for(int i = 0; i < n; i++)
			ans[i] = 1;

		for(int i = 0; i < n - 1; i++){
			if (A[i + 1] > A[i]){
				ans[i + 1] = ans[i] + 1;
			}
		}
		for(int i = n - 2; i >= 0; i--){
			if (A[i] > A[i + 1] && ans[i] <= ans[i + 1]){
				ans[i] = ans[i + 1] + 1;
			}
			sum += ans[i];
		}

		sum += ans[n - 1];
		return sum;
	}
}
