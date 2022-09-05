package Array.medium_level;

import java.util.HashMap;
import java.util.Scanner;
/*
It is nice if it satisfies all of the following conditions:

1 -> 0 <= i < j < nums.length
2 -> nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])

Return the number of nice pairs of indices. Since that number can be too large, return it modulo 109 + 7
*/
public class Count_nice_pairs_in_array {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int pairs = countNicePairs(A);
		System.out.println(pairs);
	}
	public static int countNicePairs(int[] nums) {
		HashMap<Long , Integer> hm = new HashMap<>();
		int mod = 1000000007;
		long count = 0;
		for(int a: nums){
			long rev=reverse(a);
			long diff=a-rev;
			if(hm.containsKey(diff)){
				count=(count%mod + hm.get(diff)%mod)%mod;
			}

			hm.put(diff,hm.getOrDefault(diff,0)+1);
		}
		return (int)count;
	}
	public static int reverse(int num){
		int number = 0;
		while(num!=0){
			number = number*10 + num%10;
			num = num/10;
		}
		return number;
	}
}
