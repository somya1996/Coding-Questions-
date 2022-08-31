package Array.medium_level.Hashing;

import java.util.HashSet;
import java.util.Scanner;

public class Maximum_Erasure_Value {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];

		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = maximumUniqueSubarray(A);
		System.out.println(ans);
	}
	public static int maximumUniqueSubarray(int[] nums) {
		HashSet<Integer>hs = new HashSet<>();
		int start = 0 , end = 0 , sum = 0 , ans = 0;
		while(end < nums.length && start< nums.length){
			if(hs.contains(nums[end])){
				while(hs.contains(nums[end]) && start<=end){
					sum -= nums[start];
					hs.remove(nums[start]);
					start++;
				}
			}
			hs.add(nums[end]);
			sum += nums[end];
			ans = Math.max(ans , sum);
			end++;
		}
		return ans;
	}
}
