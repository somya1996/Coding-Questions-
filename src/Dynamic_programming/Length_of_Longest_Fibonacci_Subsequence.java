package Dynamic_programming;

import java.util.HashSet;
import java.util.Scanner;

public class Length_of_Longest_Fibonacci_Subsequence {
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
	public static int solve(int[] A){
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<A.length; i++){
			hs.add(A[i]);
		}
		int res = Integer.MIN_VALUE;
		for(int i=0; i<A.length; i++){
			for(int j=i+1; j<A.length; j++){
				int count = 2;
				int first = A[i];
				int second = A[j];
				int third = first+second;
				while(hs.contains(third)){
					count++;
					first = second;
					second = third;
					third = first + second;
				}
				res = Math.max(res , count);
			}
		}
		return res>2?res:0;
	}
}
