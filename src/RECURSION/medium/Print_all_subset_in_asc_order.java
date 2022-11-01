package RECURSION.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Print_all_subset_in_asc_order {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			arr.add(sc.nextInt());
		}
		ArrayList<ArrayList<Integer>> ans = subsets(arr);
		System.out.println(ans);
	}
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

		subset(A , 0 , ans , new ArrayList<>());
		Collections.sort(ans, (ArrayList < Integer > first, ArrayList < Integer > second) -> {
			for (int i = 0; i < first.size() && i < second.size(); i++) {
				if (first.get(i) < second.get(i))
					return -1;
				if (first.get(i) > second.get(i))
					return 1;
			}
			if (first.size() > second.size())
				return 1;
			return -1;
		});
		return ans;
	}
	public static void subset(ArrayList<Integer>A , int idx ,ArrayList<ArrayList<Integer>>ans, ArrayList<Integer>ds){
		// base case
		if(idx == A.size()){
			ans.add(new ArrayList<>(ds));
			return;
		}
		// rec case
		ds.add(A.get(idx));
		subset(A , idx+1 ,ans , ds);
		ds.remove(ds.size()-1);
		subset(A , idx+1 ,ans , ds);
	}
}
