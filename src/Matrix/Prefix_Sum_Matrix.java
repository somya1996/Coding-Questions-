package Matrix;

import java.util.Scanner;

public class Prefix_Sum_Matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int A[][] = new int[n][m];
		for(int i=0; i<n; i++){
			for(int j =0; j<m; j++){
				A[i][j] = sc.nextInt();
			}
		}
		int A_[][] = prefix_sum(A);
		for(int i=0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(A_[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] prefix_sum(int[][] A){
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
		return mat;
	}
}
