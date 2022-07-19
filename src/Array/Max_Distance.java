package Array;

import java.util.Scanner;

public class Max_Distance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = maximumGap(A);
		System.out.println(ans);
	}
	public static int maximumGap(final int[] A) {
		int max_A[] = new int[A.length];
		int n = A.length;
		max_A[n-1] = A[n-1];
		for(int i=n-2; i>=0; i--){
			max_A[i] = Math.max(max_A[i+1] , A[i]);
		}
		int i = 0;
		int j = 0;
		int maxsum = 0;
		while(i < max_A.length && j < max_A.length){
			if(A[i] <= max_A[j]){
				maxsum = Math.max(maxsum , j-i);
				j++;
			}
			else{
				i++;
			}
		}
		return maxsum;
	}
}
