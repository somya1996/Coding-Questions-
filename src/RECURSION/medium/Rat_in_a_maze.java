package RECURSION.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class Rat_in_a_maze{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] maze = new int[n][n];
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				maze[i][j] = sc.nextInt();
			}
		}
		ArrayList<String> ans = findPath(maze , n);
		System.out.println(ans);
	}
	public static ArrayList<String> findPath(int[][] m, int n) {
		int[][] visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = 0;
			}
		}

		ArrayList<String>ans = new ArrayList<String>();
		if(m[0][0] == 1)
			solve(0, 0, m, n, ans, "", visited);
		return ans;
	}
	public static void solve(int i, int j, int a[][], int n, ArrayList < String > ans, String move, int vis[][]) {
        if(i == n-1 && j == n-1){
            ans.add(move);
            return;
        }
        if(i+1 < n && vis[i+1][j] == 0 && a[i+1][j]==1){
            vis[i+1][j] = 1;
            solve(i+1 , j , a , n , ans , move+"D", vis);
            vis[i+1][j] = 0;
        }
        if(j-1 >= 0 && vis[i][j-1] == 0 && a[i][j-1]==1){
            vis[i][j-1] = 1;
	        solve(i , j-1 , a , n , ans , move+"L", vis);
            vis[i][j-1] = 0;
        }
        if(j+1 < n && vis[i][j+1] == 0 && a[i][j+1]==1){
            vis[i][j+1] = 1;
	        solve(i , j+1 , a , n , ans , move+"R", vis);
            vis[i][j+1] = 0;
        }
        if(i-1 >= 0 && vis[i-1][j] == 0 && a[i-1][j]==1){
            vis[i-1][j] = 1;
	        solve(i-1 , j , a , n , ans , move+"U", vis);
            vis[i-1][j] = 0;
        }
	}
}
