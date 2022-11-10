package Dynamic_programming;

import java.util.ArrayList;
import java.util.Scanner;

public class Min_Sum_Path_in_Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> al = new ArrayList<>();
		for(int i=0; i<n; i++){
			ArrayList<Integer> list = new ArrayList<>();
			for(int j=0; j<=i; j++){
				list.add(sc.nextInt());
			}
			al.add(list);
		}
		int ans = minimumTotal(al);
		System.out.println(ans);
	}
	public static int minimumTotal(ArrayList<ArrayList<Integer>> a){
		int dp[][] = new int[a.size()][2*a.size()];
		for(int i=0; i<dp.length; i++){
			for(int j=0; j<dp[0].length; j++){
				dp[i][j] = -1;
			}
		}
		return top_down(a , 0 , 0 , dp);
	}
	public static int top_down(ArrayList<ArrayList<Integer>>a , int row , int col , int[][]dp){
		if(row == a.size())
			return 0;
		if(dp[row][col] != -1)
			return dp[row][col];
		dp[row][col] = a.get(row).get(col) + Math.min(top_down(a , row+1 , col , dp) , top_down(a , row+1 , col+1 , dp));
		return dp[row][col];
	}
}
