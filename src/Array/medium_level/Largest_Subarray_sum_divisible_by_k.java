package Array.medium_level;

import java.util.HashMap;
import java.util.Scanner;

public class Largest_Subarray_sum_divisible_by_k {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int ans = longestSubarrWthSumDivByK(arr , k);
		System.out.println(ans);
	}
	static int longestSubarrWthSumDivByK(int arr[] , int k){
		HashMap<Integer,Integer> hm = new HashMap<>();
		int sum = 0;
		int rem = 0;
		int len = 0;
		hm.put(0 , -1);
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			rem = sum % k;
			if(rem < 0){
				rem += k;
			}
			if(hm.containsKey(rem)){
				int idx = hm.get(rem);
				int l = i - idx;
				len = Math.max(len , l);
			}
			else{
				hm.put(rem , i);
			}
		}
		return len;
	}
}
