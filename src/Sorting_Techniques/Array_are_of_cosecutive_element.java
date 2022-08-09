package Sorting_Techniques;

import java.util.Scanner;

public class Array_are_of_cosecutive_element {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int ans = solve(arr);
		System.out.println(ans);
	}
	public static int solve(int[] A) {
		int min = Integer.MAX_VALUE;
		for(int i=0; i<A.length; i++){
			min = Math.min(min , A[i]);
		}
		int maxelement = min + (A.length-1);

		for (int i=0; i<A.length; i++){
			if(A[i]>maxelement)
				return 0;
			else{
				int ele = Math.abs(A[i]);
				int index = maxelement - ele;
				A[index] = -A[index];
			}
		}
		for (int i=0; i<A.length; i++){
			if(A[i]>0)
				return 0;
		}
		return 1;
	}
}
