package Matrix;

import java.util.Scanner;

public class Count_square_Matrix_with_all_one {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		int arr[][] = new int[R][C];
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(countSquares(arr));
	}
	public static int countSquares(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 0)
					continue;
				else {
					if (i == 0 || j == 0)
						continue;
					else
						matrix[i][j] = Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
					matrix[i][j] = matrix[i][j] + 1;
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}
}
