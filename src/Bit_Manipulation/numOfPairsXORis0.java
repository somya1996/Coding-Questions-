package Bit_Manipulation;

import java.util.Arrays;
import java.util.Scanner;

public class numOfPairsXORis0 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int count = XORpairZERO(arr , n);
		System.out.println(count);
	}
	public static int XORpairZERO(int[] arr , int n){
		Arrays.sort(arr);
		int count = 1 , ans = 0;
		for (int i = 1; i < n; i++) {
			// Counting frequency of each elements
			if (arr[i] == arr[i - 1]) {
				count += 1;
				//System.out.println("if"+" i "+i+" i-1 "+(i-1)+" count "+count);
			}
			else {
				// Adding the contribution of the frequency
				// to the answer
				ans = ans + (count * (count - 1)) / 2;
				count = 1;
				//System.out.println("else"+" i "+i+" i-1 "+(i-1)+" count "+count);
			}
		}
		ans = ans + (count * (count - 1)) / 2;
		return ans;
	}
}
