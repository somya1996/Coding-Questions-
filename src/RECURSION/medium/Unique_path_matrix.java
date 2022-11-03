package RECURSION.medium;

import java.util.Scanner;

public class Unique_path_matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int grid[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				grid[i][j] = sc.nextInt();
			}
		}
		int ans = solve(grid);
		System.out.println(ans);
	}

	public static int solve(int[][] A){
		int sx = 0 , sy = 0 , zero = 0;
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				if(A[i][j] == 0){
					zero++;
				}
				if(A[i][j] == 1){
					sx = i;
					sy = j;
				}
			}
		}
		return destination_search(A , sx , sy , zero);
	}
	public static int destination_search(int grid[][], int x , int y , int zero){
		// base case
		if(x>= grid.length || x < 0 || y>=grid[0].length || y<0 || grid[x][y] == -1)
			return 0;
		if(grid[x][y] == 2)
			return zero == -1?1:0;
		/**  Why zero = -1, because in above example we have 9 zero's. So, when we reach
		 *  the final cell we are covering one cell extra then the zero count. that is 1
		 *  in starting when we are on 1 it is also cosidering as one cell
		 *  so this cell is extra
		 *  */
		// rec case
		grid[x][y] = -1;
		zero--;
		int total = destination_search(grid , x-1 , y , zero)+
				destination_search(grid , x+1 , y , zero)+
				destination_search(grid , x , y-1 , zero)+
				destination_search(grid , x , y+1 , zero);
		grid[x][y] = 0;
		zero++;
		return total;
	}
}
