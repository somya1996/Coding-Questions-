package Array.Hard_level;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Pair_sum_divisible_by_m {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int total = Pair_Sum(arr , k);
		System.out.println(total);
	}
	public static int Pair_Sum(int arr[] , int k){
		/*
		HashMap<Integer,Integer> hm = new HashMap<>();
		int count = 0;
		for(int x : arr){
			int rem = x%k;
			if(hm.containsKey(rem)){
				hm.put(rem , hm.get(rem)+1);
			}
			else{
				hm.put(rem , 1);
			}
		}
		System.out.println(hm);
		for(int x : hm.keySet()){
			int rem = x % k;
			//case 1 :
			if(rem == 0){
				int freq = hm.get(rem);
				if(freq > 2){
					count += freq/2;
				}
			}
			//case 2 :
			if(2*rem == k){
				int freq = hm.get(rem);
				//if(freq % 2 == 0){
				//	count += freq;
				//}
				if(freq > 2){
					count += freq/2;
				}
			}
			// case 3:
			else{
				int freq = hm.get(rem);  //k
				System.out.println(" rem "+rem);
				System.out.println(" freq "+freq);
				int ofreq = hm.getOrDefault(k-rem , 0); // k-x
				System.out.println(" ofreq "+ofreq);
				if(freq == ofreq){
					count += (freq*ofreq);
					System.out.println(" count "+count);
				}
			}
		}
		return count;
		*/


		int freq[] = new int[k];
		Arrays.fill(freq , 0);
		int count = 0;
		for(int i=0; i<arr.length; i++){
			int rem = arr[i]%k;
			int prev_freq = freq[arr[k-rem]%k];
			count += prev_freq;
			freq[rem]++;
		}
		for(int i=0; i< freq.length; i++){
			System.out.print(freq[i]+" ");
		}
		return count;

	}
}
