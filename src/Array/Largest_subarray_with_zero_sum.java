package Array;

import java.util.HashMap;
import java.util.Scanner;

/*Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.
Input:
N = 8
A[] = {15,-2,2,-8,1,7,10,23}
Output: 5
Explanation: The largest subarray with
sum 0 will be -2 2 -8 1 7.*/
public class Largest_subarray_with_zero_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int len = maxLen(arr,n);
		System.out.println(len);
	}
	public static int maxLen(int A[], int n){
		int sum = 0;
		int maxlength = 0;
		HashMap<Integer,Integer> hm = new HashMap<>();
		hm.put(0,-1);
		for(int i=0; i<A.length; i++){
			sum += A[i];
			if(A[i] == 0 && maxlength == 0 ){
				maxlength = i;
			}
			if(hm.containsKey(sum)){
				int len = i - hm.get(sum);
				maxlength = Math.max(len,maxlength);
			}
			else{
				hm.put(sum , i);
			}

		}
		return maxlength;
	}
}
