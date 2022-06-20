package Bit_Manipulation.Medium;

import java.util.Arrays;
import java.util.Scanner;

public class Minimum_pair_XOR {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int count = Min_XOR_Pair(arr , n);
		System.out.println(count);
	}
	public static int Min_XOR_Pair(int[] arr , int n){
		int min = Integer.MAX_VALUE ;
		Arrays.sort(arr);
		for(int i=0; i<arr.length-1; i++){
			int xor = arr[i]^arr[i+1];
			min = Math.min(min , xor);
		}
		return min;
	}
}
