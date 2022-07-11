package RECURSION;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// TC - O(N)
public class Check_if_pallindrome {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		/*if(is_pallindrome(0 ,s , s.length()-1))
			System.out.println(1);
		else
			System.out.println(0);
		*/
		System.out.println(is_pallindrome(0,s));
	}
	// parameterized recursion
	/*public static boolean is_pallindrome(int s , String str , int l){
		if(s>=l)
			return true;
		if(str.charAt(s) != str.charAt(l))
			return false;
		return is_pallindrome(s+1,str,l-1);
	}*/
	// functional recursion
	public static boolean is_pallindrome(int i , String str){
		int n = str.length()-1;
		if(i == str.length()/2)
			return true;
		if(str.charAt(i)!=str.charAt(n-i-1))
			return false;
		return is_pallindrome(i+1 , str);
	}

	public static class combinational_sum {
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

	public static class Gray_Code {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			System.out.println(grayCode(n));

		}
		int num = 0;
		public static ArrayList<Integer> grayCode(int a) {
			/*
			//One way
			ArrayList<Integer> start = new ArrayList<>();
			if(a == 1){
				start.add(0);
				start.add(1);
				return start;
			}
			ArrayList<Integer> ans = grayCode(a-1);
			// Now loop to iterate each elements in an arraylist to get new output
			int x = ans.size();
			for( int i = 0; i<x; i++){
				start.add(ans.get(i));
			}
			for(int j=x-1; j>=0; j--) {
				start.add(ans.get(j) + (1 << (a - 1)));
			}
			return start;
			*/
			ArrayList<Integer> ans = new ArrayList<>();
			solve(ans , a , 0);
			return ans;

		}
		public static ArrayList<Integer> solve(ArrayList<Integer> res , int A , int element){
			if(res.size()==(1<<A))
				return res;
			System.out.println(res);
			res.add((element ^ (element>>1)));

			return solve(res,A,element+1);
		}
	}
}
