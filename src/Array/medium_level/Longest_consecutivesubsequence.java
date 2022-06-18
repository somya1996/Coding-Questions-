package Array.medium_level;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_consecutivesubsequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		int count = findLongestConseqSubseq(arr , n);
		System.out.println(count);
	}
	public static int findLongestConseqSubseq(int arr[], int N){
		int max_ele = Integer.MIN_VALUE;
		for(int i=0; i<N; i++){
			max_ele = Math.max(arr[i],max_ele);
		}
		boolean isPresent[] = new boolean[max_ele+1];
		for(int i=0; i<arr.length; i++){
			isPresent[arr[i]] = true;
		}
		int count = 0;
		int total = 0;
		for(int i=0; i<isPresent.length; i++){
			if(isPresent[i] == true){
				count++;
				total = Math.max(count,total);
			}
			else{
				count = 0;
			}
		}
		return total;
	}
}
