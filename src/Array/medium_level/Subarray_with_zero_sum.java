package Array.medium_level;

import java.util.HashSet;
import java.util.Scanner;

public class Subarray_with_zero_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];

		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = solve(A);
		System.out.println(ans);
	}
	public static int solve(int[] A) {
		HashSet<Long> hs = new HashSet<Long>();
		long sum = 0;
		hs.add(sum);
		for(int i=0; i<A.length; i++){
			sum += A[i];
			if(hs.contains(sum)){
				return 1;
			}
			else{
				hs.add(sum);
			}
		}
		return 0;
	}
}
