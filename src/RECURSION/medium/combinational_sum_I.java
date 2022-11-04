package RECURSION.medium;

import java.util.*;

public class combinational_sum_I {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			arr.add(sc.nextInt());
		}
		int target = sc.nextInt();
		System.out.println(combinationSum1(arr , target));
	}
	public static List<List<Integer>> combinationSum1(ArrayList<Integer> candidates, int target) {
		List<List<Integer>> ans = new ArrayList<>();
		Collections.sort(candidates);
		combinationalSum1(0 , candidates , target , ans , new ArrayList<>());
		return ans;
	}
	public static void combinationalSum1(int idx , ArrayList<Integer>A , int target ,
	                              List<List<Integer>> ans , ArrayList<Integer>list){
		// base case
		if (idx == A.size()) {
			if (target == 0) {
				ans.add(new ArrayList < > (list));
			}
			return;
		}

		// rec case
		if(target >= A.get(idx)){
			list.add(A.get(idx));
			combinationalSum1(idx, A, target-A.get(idx), ans , list);
			list.remove(list.size()-1);
		}
		combinationalSum1(idx+1 , A , target , ans , list);
	}
}
