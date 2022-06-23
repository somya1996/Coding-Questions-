package RECURSION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class combinational_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(combinationSum(arr , target));
	}
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		combinational(0 , candidates , target , ans , new ArrayList<Integer>());
		return ans;
	}
	public static void combinational(int idx , int[] candidate , int target , List<List<Integer>> ans , ArrayList<Integer>ds){
		// Base case
		if(idx == candidate.length){
			if(target == 0){
				ans.add(new ArrayList<>(ds));
			}
			return;
		}

		// taking elements
		if(target >= candidate[idx]) {
			ds.add(candidate[idx]);
			combinational(idx, candidate, target - candidate[idx], ans, ds);
			ds.remove(ds.size()-1);
		}
		// not taking element jumping to next index value
		combinational(idx+1 , candidate , target , ans , ds);
	}
}
