package RECURSION.medium;

import java.util.Scanner;

public class JumP_game_recursive{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] A = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int ans = minjumps(A,0 , A.length-1);
		System.out.println(ans);
	}
	public static int minjumps(int[] arr , int start , int end){
		// base case
		if(start == end)
			return 0;
		if(arr[start] == 0)
			return Integer.MAX_VALUE;
		// so that it will never be counted in minimum jumps
		// if we put it as -1 then it will reduce np of jumps with -1 and can contribute in ans but
		// in actual it can't

		// work space
		int min = Integer.MAX_VALUE;
		for(int i = start+1; i<=end && i<=start+arr[start]; i++){
			int jump = minjumps(arr , i , end);
			if(jump != Integer.MAX_VALUE && jump+1<min){
				min = jump+1;
		    }
		}
		return min;
	}
}
