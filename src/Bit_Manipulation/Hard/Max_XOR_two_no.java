package Bit_Manipulation.Hard;

import java.util.HashSet;
import java.util.Scanner;

public class Max_XOR_two_no {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int count = MAx_XOR_Pair(arr , n);
		System.out.println(count);
	}
	public static int MAx_XOR_Pair(int arr[] , int n){
		int mask = 0 , ans = 0;
		for(int bit=31; bit>=0; bit--){
			mask = mask|(1<<bit);
			HashSet<Integer>hs = new HashSet<>();
			for(int i=0; i<n; i++){
				hs.add(mask&arr[i]);
			}
			int newmax = ans|(1<<bit);
			for(int prefix : hs){
				if(hs.contains(newmax^prefix)){
					ans = newmax;
					break;
				}
			}
		}
		return ans;
	}
}
