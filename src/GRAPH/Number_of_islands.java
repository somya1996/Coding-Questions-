package GRAPH;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Number_of_islands {
	class Pair{
		int first;
		int second;
		Pair(int f , int s){
			first = f;
			second = s;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("row");
		int n = sc.nextInt();
		System.out.println("col");
		int m = sc.nextInt();
		int A[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				A[i][j] = sc.nextInt();
			}
		}
		System.out.println("ans");
		Number_of_islands nof = new Number_of_islands();
		int ans = nof.solve(A);
		System.out.println(ans);
	}
	public int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;
		int[][] vis = new int[n][m];
		int cnt = 0;
		for(int row = 0; row < n ; row++) {
			for(int col = 0; col < m ;col++) {
				// if not visited and is a land
				if(vis[row][col] == 0 && A[row][col] == 1) {
					cnt++;
					bfs(row, col, vis, A);
				}
			}
		}
		return cnt;
	}

	public void bfs(int row , int col , int[][] vis , int[][] A){
		int n = A.length;
		int m = A[0].length;
		vis[row][col] = 1;
		Queue<Pair>q = new LinkedList<Pair>();
		q.add(new Pair(row , col));

		while(!q.isEmpty()){
			int r = q.peek().first;
			int c = q.peek().second;
			q.remove();


			for(int delrow = -1; delrow <= 1; delrow++){
				for(int delcol = -1; delcol <= 1; delcol++){
					int nrow = r + delrow;
					int ncol = c + delcol;

					if(nrow >= 0 && nrow< n && ncol >= 0 && ncol < m && A[nrow][ncol] == 1 && vis[nrow][ncol] == 0){
						vis[nrow][ncol] = 1;
						q.add(new Pair(nrow , ncol));
					}
				}
			}
		}
	}
}
/*
vis[ro][co] = 1;
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(new Pair(ro, co));
		int n = A.length;
		int m = A[0].length;

		// until the queue becomes empty
		while(!q.isEmpty()) {
			int row = q.peek().first;
			int col = q.peek().second;
			q.remove();

			// traverse in the neighbours and mark them if its a land
			for(int delrow = -1; delrow<=1;delrow++) {
				for(int delcol = -1; delcol <= 1; delcol++) {
					int nrow = row + delrow;
					int ncol = col + delcol;
					// check if neighbour row and column is valid, and is an unvisited land
					if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
							&& A[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
						vis[nrow][ncol] = 1;
						q.add(new Pair(nrow, ncol));
					}
				}
			}
		}
 */