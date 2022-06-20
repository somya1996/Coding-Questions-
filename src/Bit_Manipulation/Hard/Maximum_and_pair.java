package Bit_Manipulation.Hard;

import java.util.Scanner;

public class Maximum_and_pair {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int max = maxAND(arr , n);
		System.out.println(max);
	}
	public static int maxAND (int arr[], int N) {
		int count=0 , res = 0;
		for(int bit = 31; bit >= 0; bit--){
			 count = countBit(res|(1<<bit) , arr , N);
			 if(count >= 2){
				 res = res|(1<<bit);
			 }
		}
		return res;
	}
	public static int countBit(int pattern , int[] arr , int N){
		int count = 0;
		for(int i=0; i<N; i++) {
			if ((pattern & arr[i]) == pattern)
				count++;
		}
		return count;
	}
}
