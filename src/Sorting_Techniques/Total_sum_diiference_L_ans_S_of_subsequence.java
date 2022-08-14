package Sorting_Techniques;

import java.util.Arrays;
import java.util.Scanner;

public class Total_sum_diiference_L_ans_S_of_subsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		int ans = solve(arr);
		System.out.println(ans);
	}
	public static int solve(int[] A) {
		long sum =0;
		int n = A.length;
		int mod = 1000000009;
		Arrays.sort(A);
		for(int i=0;i<=A.length-1; i++)
		{
			int j = i+1;
			int x = 0;
			while(j<A.length)
			{
				int diff = (A[j]- A[i])%mod;
				sum = (sum+ diff*pow(2,x,mod)) %mod;
				j++;
				x++;
			}

		}
		return (int)(sum%1000000007);
	}
	public static long pow(int n, int p, int mod){
		if(p==0) return 1;
		if(p==1) return n;
		long pow=1;

		pow= pow(n, p/2, mod)%mod;
		pow=(pow%mod * pow%mod)%mod;
		if(p%2==1){
			pow=(n%mod * pow%mod)%mod;
		}
		return pow;

	}
}
