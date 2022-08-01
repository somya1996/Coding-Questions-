package Array.medium_level;

import java.util.Arrays;
import java.util.Scanner;

public class prime_addition {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int ans = solve(A);
		System.out.println(ans);
	}
	public static int solve(int A) {
		//sieve array
		boolean isPrime[] = new boolean[A + 1];
		int ans = 0;
		sieve(A, isPrime);
		for (int i = 0; i < A; i++) {
			if (isPrime[i] && isPrime[A - i]) {
				ans += 2;
				break;
			}
		}
		return ans;
	}
	public static void sieve(int n, boolean[] isPrime) {
		isPrime[0] = isPrime[1] = false;
		for (int i = 2; i <= n; i++)
			isPrime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			// If isPrime[p] is not changed, then it is a
			// prime
			if (isPrime[p] == true) {
				// Update all multiples of p
				for (int i = p * p; i <= n; i += p)
					isPrime[i] = false;
			}
		}

		for(int i=0; i<n; i++){
			System.out.println(isPrime[i]);
		}
	}
}


