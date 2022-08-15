package Sorting_Techniques;

import java.util.Scanner;

public class Maximum_and_Minimum_magic {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int[] ans = solve(arr);
		for(int i=0; i<ans.length; i++)
			System.out.println(ans[i]);
	}
	public static int[] solve(int[] A) {
		int []ans = new int[2];
		int n = A.length;
		for(int i=0; i<n-1; i++){

		}
		return ans;
	}
}
