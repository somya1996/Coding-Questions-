package GRAPH;

import java.util.Arrays;
import java.util.Scanner;

public class No_of_enclaves {
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
		No_of_enclaves ne = new No_of_enclaves();
		int ans = ne.numEnclaves(A);
		System.out.println(ans);
	}
	public int numEnclaves(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[] dx = {-1 , 0 , +1, 0};
		int[] dy = {0 , +1 , 0 , -1};
		int vis[][] = new int[n][m];
		for(int[] rows: vis)
			Arrays.fill(rows , 0);
		for(int i=0; i<n; i++){
			if(grid[i][0] == 1 && vis[i][0] == 0)
				dfs(i , 0 , grid , vis , dx , dy);
			if(grid[i][m-1] == 1 && vis[i][m-1] == 0)
				dfs(i , m-1 , grid , vis , dx , dy);
		}
		for(int j=0; j<m; j++){
			if(grid[0][j] == 1 && vis[0][j] == 0)
				dfs(0 , j , grid , vis , dx , dy);
			if(grid[n-1][j] == 1 && vis[n-1][j] == 0)
				dfs(n-1 , j , grid , vis , dx , dy);
		}

		int count = 0;
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				if(grid[i][j] == 1 && vis[i][j] == 0)
					count++;
			}
		}
		return count;
	}
	public static void dfs(int r , int c , int[][] matrix , int[][] vis , int[] dx , int[] dy){
		vis[r][c] = 1;
		int n = matrix.length;
		int m = matrix[0].length;

		for(int i=0; i<4; i++){
			int nr = r + dx[i];
			int nc = c + dy[i];
			if(nr >= 0 && nr < n && nc >=0 && nc < m && matrix[nr][nc] == 1 && vis[nr][nc] == 0)
				dfs(nr , nc , matrix , vis , dx , dy);
		}
	}
}
