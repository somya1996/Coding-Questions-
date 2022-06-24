package RECURSION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class subset_sum_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(subsetsWithDup(arr));
	}
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		findSubsets(0 , nums , new ArrayList<>() , ans);
		return ans;
	}
	public static void findSubsets(int idx , int[] nums , List<Integer> ds , List<List<Integer>> ans){
		ans.add(new ArrayList<>(ds));
		for(int i = idx ; i < nums.length; i++){
			if(i!=idx && nums[i]== nums[i-1])
				continue;
			ds.add(nums[i]);
			findSubsets(i+1 , nums , ds , ans);
			ds.remove(ds.size()-1);
		}
	}
}
