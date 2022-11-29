package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class No_of_distinct_island {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] A = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				A[i][j] = sc.nextInt();
			}
		}
		No_of_distinct_island ndi = new No_of_distinct_island();
		int ans = ndi.countDistinctIslands(A);
		System.out.println(ans);
	}
	int countDistinctIslands(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int vis[][] = new int[n][m];
		HashSet < ArrayList < String >> hs = new HashSet < > ();

		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(vis[i][j] == 0 && grid[i][j] == 1){
					ArrayList<String> vector = new ArrayList<>();
					dfs(i , j , vis , grid , vector , i , j);
					hs.add(vector);
				}
			}
		}
		return hs.size();

	}

	public void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> vector, int r0, int c0){
		int n = grid.length;
		int m = grid[0].length;

		vis[row][col] = 1;
		vector.add(toString(row-r0 , col-c0));

		int[] dx = {-1 , 0 , +1 , 0};
		int[] dy = {0 , -1 , 0 , +1};

		for(int i=0; i<4; i++){
			int nr = row + dx[i];
			int nc = col + dy[i];
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0 && grid[nr][nc] == 1){
				dfs(nr , nc , vis , grid , vector , r0 , c0);
			}
		}
	}
	private String toString(int r, int c) {
		return Integer.toString(r) + " " + Integer.toString(c);
	}
}
