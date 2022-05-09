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
}