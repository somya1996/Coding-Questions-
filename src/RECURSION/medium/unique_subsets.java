package RECURSION.medium;

import javax.print.attribute.HashAttributeSet;
import java.util.*;

public class unique_subsets {
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
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer>A){
		Collections.sort(A);
		ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
		HashSet<ArrayList<Integer>> hs = new HashSet<ArrayList<Integer>>();
		unique_subset(A , 0 , new ArrayList<>() , ans , hs);
		Collections.sort(ans, (ArrayList<Integer> o1 , ArrayList<Integer>o2)->{
			for(int i=0; i<o1.size() && i<o2.size(); i++){
				if(o1.get(i) < o2.get(i))
					return -1;
				if(o1.get(i) > o2.get(i))
					return 1;
			}
			if(o1.size()>o2.size())
				return 1;
			return -1;
		});
		return ans;
	}
	public static void unique_subset(ArrayList<Integer>A , int idx , ArrayList<Integer>list ,
	                                      ArrayList<ArrayList<Integer>>ans,
	                                      HashSet<ArrayList<Integer>> hs){
		if(idx == A.size()){
			if(!hs.contains(list)){
				ans.add(new ArrayList<>(list));
				hs.add(list);
			}
			return;
		}
		list.add(A.get(idx));
		unique_subset(A , idx+1 , list , ans , hs);
		list.remove(list.size()-1);
		unique_subset(A , idx+1 , list , ans , hs);
	}
}
