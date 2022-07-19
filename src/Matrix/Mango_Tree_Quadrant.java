package Matrix;

import java.util.Scanner;
/*
Ramu's fathe has left a farm organized as an N*N grid.Each square in the grid either has or does not have a mango tree .
He has to divide the farm with his three sister as follows:-
He will draw one horizontal line and one vertical line to divide the field in four rectangle . His sisters will choose
three of the four smaller fields and he get the last one.

He wants to divide the field so that he gets the maximum number of mangoes possible , assuming that his sister will
pick the best three rectangle.
. # # . . .
# . . # # .
. # . . . .
. # # . . #
# . . # # .
. # . . . .
*/

public class Mango_Tree_Quadrant {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int m = sc.nextInt();
			int A[][] = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					A[i][j] = sc.nextInt();
				}
			}
			int ans = ramu_mangoes_quadrant(A);
			System.out.println(ans);
		}
		public static int ramu_mangoes_quadrant(int [][]A){
			int[][] mat = new int[A.length][A[0].length];
			mat[0][0] = A[0][0];
			for(int col=1; col<A[0].length; col++){
				mat[0][col] = mat[0][col-1]+A[0][col];
			}
			for(int row=1; row<A.length; row++){
				mat[row][0] = mat[row-1][0]+A[row][0];
			}

			for(int row=1; row<A.length; row++){
				for(int col=1; col<A[0].length; col++){
					mat[row][col] = mat[row-1][col] + mat[row][col-1] - mat[row-1][col-1] + A[row][col];
				}
			}

			int max_mangoes = 0;
			int n = A.length;
			int m = A[0].length;
			for(int i=1; i< mat.length-1; i++){
				for(int j=1; j<mat[0].length-1; j++){
					// no rectangle is divided in 4 quadrant Q1 Q2 Q3 Q4
					int Q1 = mat[i][j];
					int Q2 = mat[i][n-1] - Q1;
					int Q3 = mat[m-1][j] - Q1;
					int Q4 = mat[n-1][m-1] - Q1 -Q2 - Q3;
					int ramu_min = Q1;
					ramu_min = Math.min(ramu_min , Q2);
					ramu_min = Math.min(ramu_min , Q3);
					ramu_min = Math.min(ramu_min , Q4);
					max_mangoes = Math.max(ramu_min , max_mangoes);
				}

			}
			return max_mangoes;
		}
}
