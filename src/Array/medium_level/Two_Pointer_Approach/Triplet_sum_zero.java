package Array.medium_level.Two_Pointer_Approach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Triplet_sum_zero {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}

		/*int[][] ans = threeSum(arr);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans[0].length; j++){
				System.out.println(ans[i]);
			}
		}*/
		ArrayList<ArrayList<Integer>> ans = threeSum(arr);
		System.out.println(ans);
	}
	public static ArrayList<ArrayList<Integer>> threeSum(int[] A) {
		ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();

		Arrays.sort(A);
		int T = 0;
		int n = A.length;
		for(int i=0; i<n-2; i++) {
			int target = T - A[i];
			int low = i + 1, high = n - 1;
			while (low < high) {
				if (A[low] + A[high] < target) {
					low++;
				}
				else if(A[low]+A[high] > target)
					high--;
				else{
					ArrayList<Integer> ds = new ArrayList<>();
						ds.add(A[i]);
						ds.add(A[low]);
						ds.add(A[high]);
					//al.add(ds);
					low++;
					high--;
					if(!al.contains(ds))
						al.add(ds);
				}

			}
		}
		return al;
	}
}
