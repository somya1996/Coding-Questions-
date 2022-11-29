package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Distance_of_nearest_cell {
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
		Distance_of_nearest_cell donc = new Distance_of_nearest_cell();

		int[][] ans = donc.solve(A);
		System.out.println();
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	class Pair{
		int row;
		int col;
		int steps;
		Pair(int f , int s , int t){
			row = f;
			col = s;
			steps = t;
		}
	}
	public int[][] solve(int[][] A){
		int n = A.length;
		int m = A[0].length;
		int vis[][] = new int[n][m];
		int dist[][] = new int[n][m];
		Queue<Pair> q = new LinkedList<Pair>();

		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				// start BFS if cell contains 1
				if(A[i][j] == 1) {
					q.add(new Pair(i, j, 0));
					vis[i][j] = 1;
				}
				else {
					// mark unvisted
					vis[i][j] = 0;
				}
			}
		}

		int[] dx = {-1, 0, +1, 0};
		int[] dy = {0, +1, 0, -1};

		while(!q.isEmpty()){
			Pair p = q.poll();
			int r = p.row;
			int c = p.col;
			int steps = p.steps;
			dist[r][c] = steps;

			for(int i=0; i<4; i++){
				int nr = r + dx[i];
				int nc = c + dy[i];
				if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == 0) {
						q.add(new Pair(nr, nc, steps + 1));
						vis[nr][nc] = 1;
					}
				}
			}
		return dist;
	}
}
