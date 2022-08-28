package Sorting_Techniques.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Merge_intervals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];

		for(int i=0; i<n; i++){
			for(int j = 0; j<2; j++){
				arr[i][j] = sc.nextInt();
			}
		}

		int[][] ans = overlappedInterval(arr);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<2; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}

	}
	public static int[][] overlappedInterval(int[][] intervals){
		Arrays.sort(intervals , (a,b)-> Integer.compare(a[0] , b[0]));
		ArrayList<int[]> res = new ArrayList<>();
		for(int[] x: intervals){
			if(res.isEmpty())
				res.add(x);
			else{
				int[] previous_ele = res.get(res.size()-1);
				if(previous_ele[1] > x[0]){
					previous_ele[1] = Math.max(x[1], previous_ele[1]);
				}
				else{
					res.add(x);
				}
			}
		}
		return res.toArray(new int[res.size()][]);
	}
}
