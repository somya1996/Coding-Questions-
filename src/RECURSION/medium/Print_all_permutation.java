package RECURSION.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Print_all_permutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		List<List<Integer>> al = permute(arr);
		System.out.println(al);
	}
	public static List<List<Integer>> permute(int[] nums){
		List<List<Integer>> al = new ArrayList<>();
		//List<Integer> ds = new ArrayList<>();
		//boolean freq[] = new boolean[nums.length];
		//recusivepermute(nums , al , ds , freq );
		recusivepermute(0 , nums , al , new ArrayList<Integer>());
		return al;
	}
	/*
	public static void recusivepermute(int[] nums , List<List<Integer>> al , List<Integer> ds , boolean[] freq){
		// one way
		//Base Case
		if(ds.size() == nums.length) {
			al.add(new ArrayList<>(ds));
			return;
		}
		for(int i=0; i<nums.length; i++) {
			if (ds.contains(nums[i])) continue;
			ds.add(nums[i]);
			recusivepermute(nums, al, ds, freq);
			ds.remove(ds.size() - 1);
		}
	}*/
	public static void recusivepermute(int index , int[] nums ,  List<List<Integer>>ans , List<Integer>ds){
		if(index == nums.length){
			for(int i=0; i< nums.length; i++){
				ds.add(nums[i]);
			}
			ans.add(new ArrayList<>(ds));
			ds.clear();
			return;
		}
		for (int i= index; i< nums.length; i++){
			swap(i , index , nums);
			recusivepermute(index+1, nums , ans , ds);
			swap(i , index , nums);
		}
	}
	public static void swap(int i, int idx , int[] nums){
		int temp = nums[i];
		nums[i] = nums[idx];
		nums[idx] = temp;
		return;
	}
}
