package RECURSION;

import java.util.Scanner;

public class Maze_run {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int mat[][] = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				mat[i][j] = sc.nextInt();
			}
		}

		int total_ways = ways_to_reac_destination(mat , n);
		System.out.println(total_ways);
	}
	public static int ways_to_reac_destination(int[][] mat , int n){
		int ans = 0;
		for(int i=n; i>=0; i--){
			for(int j=0; j<n; j++){

			}
		}
		return ans;
	}
}
