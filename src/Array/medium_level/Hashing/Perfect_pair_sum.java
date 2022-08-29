package Array.medium_level.Hashing;

import java.util.HashMap;
import java.util.Scanner;

public class Perfect_pair_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = PerfectMatch(arr , n);
		System.out.println(ans);
	}
	static int PerfectMatch(int arr[], int n) {
		HashMap<Long,Long> hm = new HashMap<Long,Long>();
		long max_sum = -1;
		for(int i=0; i<n; i++){
			long sum = digit_sum(arr[i]);
			if(hm.containsKey(sum)){
				max_sum = Math.max(max_sum , arr[i]+hm.get(sum));
			}
			else{
				hm.put(sum , (long)arr[i]);
			}
		}
		return (int)max_sum;
	}
	public static long digit_sum(int x){
		int sum = 0;
		while(x != 0){
			sum += x%10;
			x = x/10;
		}
		return sum;
	}
}
