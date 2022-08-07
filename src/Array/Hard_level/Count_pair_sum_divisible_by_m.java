package Array.Hard_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Count_pair_sum_divisible_by_m {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int total = Pair_Sum(arr , k);
		System.out.println();
		System.out.println(total);
	}
	public static int Pair_Sum(int arr[] , int k){
		/*
		int freq[] = new int[k+1];
		Arrays.fill(freq , 0);
		int count = 0;
		for(int i=0; i<arr.length; i++){
			int rem = arr[i]%k;
			int prev_freq = freq[(k-rem)];
			count += prev_freq;
			freq[rem]++;
		}
		for(int i=0; i< freq.length; i++){
			System.out.print(freq[i]+" ");
		}
		System.out.println();
		return count;
		*/
		HashMap<Integer,Integer>hm = new HashMap<>();
		int count = 0;
		for(int i=0; i<arr.length; i++){
			int rem = arr[i]%k;
			int complement = k - rem;
			if(rem == 0) {
				if (hm.containsKey(rem)) {
					count += hm.get(rem);
				}
				else{
					hm.put(rem , 1);
				}
			}
			else if(2*k == rem){
				//count += hm.getOrDefault(rem , 0);
				if (hm.containsKey(rem)) {
					count += hm.get(rem);
				}
				else{
					hm.put(rem , 1);
				}
			}
			else{
				if(hm.containsKey(complement)){
					count += hm.get(complement);
				}
			}

		}
		return count;
	}
}
