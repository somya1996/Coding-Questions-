package Array;

import java.util.Scanner;

public class Swappin_pair_make_sum_equal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		long arr[] = new long[m];
		for(int i=0;i<m;i++){
			arr[i] = sc.nextLong();
		}

		int n = sc.nextInt();
		long brr[] = new long[n];
		for(int i=0;i<m;i++){
			brr[i] = sc.nextLong();
		}

		long ans = findSwapValues(arr,m,brr,n);
		if(ans == 0 )
			System.out.println(-1);
		System.out.println(ans);
	}
	public static long findSwapValues(long A[], int n, long  B[], int m){
		long sum1 = sum(A, n);
		long sum2 = sum(B, m);

		// Look for val1 and val2, such that
		// sumA - val1 + val2 = sumB - val2 + val1
		long newsum1, newsum2, val1 = 0, val2 = 0;
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < m; j++)
			{
				newsum1 = sum1 - A[i] + B[j];
				newsum2 = sum2 - B[j] + A[i];
				if (newsum1 == newsum2)
				{
					val1 = A[i];
					val2 = B[j];
				}
			}
		}

		return val2;
	}
	public static long sum(long arr[] , int n){
		long sum = 0;
		for(int i=0;i<n;i++)
			sum += arr[i];
		return sum;
	}
}
