package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_of_prime_no {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean isprime[] = seive_of_eratos(n);
		// to print
		for(int i=0;i<=n;i++){
			if(isprime[i] == true)
				System.out.println(i);
		}
	}
	public static boolean[] seive_of_eratos(int n){
		boolean[] isprime = new boolean[n+1];
		Arrays.fill(isprime , true);
		isprime[0] = false;
		isprime[1] = false;
		for(int i=2; i<=Math.sqrt(n); i++){
			for(int j = 2*i; j<=n; j+=i)
				isprime[j] = false;
		}
		return isprime;
	}

	public static class Freq_Lmt_Range_Arr_Ele {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int  n = sc.nextInt();
			int arr[] = new int[n];
			for(int i=0; i<n; i++){
				arr[i] = sc.nextInt();
			}
			int p = sc.nextInt();
			frequencyCount(arr,n,p);
		}
		public static void frequencyCount(int arr[], int N, int P){
			int hash[] = new int[N];
			Arrays.fill(hash, 0);
			int i = 0;
			while (i < N){
				hash[arr[i] - 1]++;
				i++;
			}
			for(i = 0; i < N; i++)
			{
				System.out.println((i + 1) + " -> " +
						hash[i]);
			}
		}
	}
}