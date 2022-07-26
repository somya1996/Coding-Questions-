package Array.Hard_level;

import java.util.HashMap;
import java.util.Scanner;

public class count_all_subarray_divisible_by_k {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int total = total_Subarry_Sum_DivByK(arr , k);
		System.out.println(total);
	}
	public static  int total_Subarry_Sum_DivByK(int[] arr , int k){
		HashMap<Integer,Integer> hm = new HashMap<>();
		int sum = 0;
		int rem = 0;
		int count = 0;
		// hashmap<remainder , frequency>
		hm.put(0 , 1);
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
			rem = sum % k;
			if(rem < 0){
				rem += k;
			}
			if(hm.containsKey(rem)){
				count += hm.get(rem);
				hm.put(rem , hm.get(rem)+1);
			}
			else{
				hm.put(rem , 1);
			}
		}
		return count;
	}
}
