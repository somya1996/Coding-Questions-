package GRAPH;

import java.util.Scanner;

public class flood_fill_algorithm {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int image[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				image[i][j] = sc.nextInt();
			}
		}
		int source = sc.nextInt();
		int destination = sc.nextInt();
		int colour = sc.nextInt();
		int[][] ans = floodFill(image , source , destination , colour);
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] floodFill(int[][] image, int sr, int sc, int newcolor) {

		int[][] temp = image;
		int initial_val = image[sr][sc];
		int delrow[] = {-1 , 0 , +1 , 0};
		int delcol[] = {0 , +1 , 0 , -1};
		dfs(image , sr , sc , newcolor , initial_val , temp , delrow , delcol);
		return temp;
	}
	public static void dfs(int[][] image , int row , int col , int color , int initial_color , int[][]temp , int[] delrow , int[] delcol){
		int n = image.length;
		int m = image[0].length;
		temp[row][col] = color;
		for(int i=0; i<4; i++){
			int nr = row + delrow[i]; //neighbour row
			int nc = col + delcol[i]; // neighbour col
			if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == initial_color && temp[nr][nc] != color){
				dfs(image , nr , nc , color , initial_color , temp , delrow , delcol);
			}
		}
		return;
	}
}
