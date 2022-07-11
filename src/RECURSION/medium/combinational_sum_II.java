package RECURSION.medium;

import java.util.*;

public class combinational_sum_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		System.out.println(combinationSum2(arr , target));
	}
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(candidates);
		combinationalSum2(0 , candidates , target , ans , new ArrayList<>());
		return ans;
	}
	public static void combinationalSum2(int idx , int[] candidate , int target , List<List<Integer>> ans , ArrayList<Integer>ds){
		// Base case
		if(idx == candidate.length){
			if(target == 0){
				if(!ans.contains(ds))
					ans.add(new ArrayList<>(ds));
			}
			return;
		}

		// taking elements
		int prev = 0;
		if(target >= candidate[idx] && candidate[idx]!= prev) {
			prev = candidate[idx];
			ds.add(candidate[idx]);
			combinationalSum2(idx+1, candidate, target - candidate[idx], ans, ds);
			ds.remove(ds.size()-1);
		}
		// not taking element jumping to next index value
		combinationalSum2(idx+1 , candidate , target , ans , ds);


		/*for (int i = idx; i < candidate.length; i++) {

			if(i > idx && candidate[i] == candidate[i-1])
				continue; // skip duplicates
			ds.add(candidate[i]);
			combinationalSum2(idx+1, candidate, target - candidate[idx], ans, ds);
			ds.add(candidate[i]);
		}*/
	}
}
