package RECURSION;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Print_all_subset_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<n; i++){
			arr.add(sc.nextInt());
		}
		ArrayList<Integer> ans = new ArrayList<>();
		System.out.println(subsetSums(0 , arr));
	}
	public static ArrayList<Integer> subsetSums(int i, ArrayList<Integer> arr){
		ArrayList<Integer> ans = new ArrayList<>();
		addition(0 , arr , 0 , ans);
		Collections.sort(ans);
		return ans;
	}
	public static void addition(int idx , ArrayList<Integer> arr , int sum , ArrayList<Integer>ans){
		//Base Case
		if(idx == arr.size()){
			ans.add(sum);
			return;
		}
		sum+= arr.get(idx);
		addition(idx+1, arr , sum , ans);
		sum -= arr.get(idx);
		addition(idx+1,arr,sum,ans);
	}

}
