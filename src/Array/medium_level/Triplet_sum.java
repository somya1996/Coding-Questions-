package Array.medium_level;

import java.util.Arrays;
import java.util.Scanner;

public class Triplet_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		boolean ans = find3Numbers(arr,n,k);
		System.out.println(ans);
	}
	public static boolean find3Numbers(int A[], int n, int X) {
		// iterating each elements and applying sliding window on rest elements
		Arrays.sort(A);
		for(int i=0; i<n-2; i++){
			int s = i+1;
			int e = n-1;
			while(s<e){
				if(A[i] + A[s] + A[e] == X){
					return true;
				}
				else if(A[i]+A[s]+A[e] < X){
					s++;
				}
				else{
					e--;
				}
			}
		}
		return false;
	}
}
