package Matrix;

import java.util.Scanner;

public class wave_matrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] ans = wave(n);
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

	public static int[][] wave(int n) {
		int mat[][] = new int[n][n];
		int count = 1;
		for(int row =0 ; row<n; row++){
			if(row % 2 == 0) {
				int col = 0;
				while(col < mat[row].length){
					mat[row][col] = count;
					count++;
					col++;
				}
			}
			else{
				int col = mat[row].length-1;
				while(col >= 0){
					mat[row][col] = count;
					count++;
					col--;
				}
			}
		}
		return mat;
	}
}
