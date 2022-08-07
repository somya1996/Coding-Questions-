package Array.medium_level;

import java.util.HashMap;
import java.util.Scanner;

public class Check_if_array_pair_divisible_by_M {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int M = sc.nextInt();
		boolean ans = sum_divisible_by_K(arr , M);
		System.out.println(ans);
	}
	public static boolean sum_divisible_by_K(int[] arr , int M){
		HashMap<Integer,Integer> hm = new HashMap<>();
		for(int i = 0; i<arr.length ; i++){
			int rem = arr[i]%M;
			if(hm.containsKey(rem))
				hm.put(rem , hm.get(rem)+1);
			else{
				hm.put(rem , 1);
			}
		}
		for(int val : arr){
			int rem = val%M;
			// special case
			if(rem == 0){
				int fq = hm.get(rem);
				if(fq%2 == 1)
					return false;
			}
			if(2 * rem == M){
				int fq = hm.get(rem);
				if(fq%2 == 1)
					return false;
			}
			int remain = M - rem;
			int fq = hm.get(rem);
			if(hm.containsKey(remain)) {
				int remain_fq = hm.get(remain);
				if (remain_fq != fq)
					return false;
			}
		}
		return true;
	}
}
