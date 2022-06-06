package Array.medium_level;

import java.util.HashMap;
import java.util.Scanner;

public class Count_pair_divisible_by_k {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		int c = count_pair(arr , n , k);
		System.out.println(c);
	}
	public static int count_pair(int []A , int n , int k){
		HashMap<Integer, Integer> hm = new HashMap<>();
		int count = 0;
		for(int i=0; i<A.length; i++){
			int rem = A[i]%k;
			/*if(hm.containsKey(rem==0?0:k-rem)){
				count += hm.get(rem==0?0:k-rem);
			}*/
			if(rem!=0)
			{
				if(hm.containsKey(k-rem))
					count+= hm.get(k-rem);
			}
			else
			{
				if(hm.containsKey(rem))
					count+= hm.get(rem);
			}
			if(hm.containsKey(rem)){
				hm.put(rem , hm.get(rem)+1);
			}
			else{
				hm.put(rem , 1);
			}
		}
		return count;
	}
}
