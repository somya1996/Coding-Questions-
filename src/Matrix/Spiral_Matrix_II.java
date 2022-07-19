package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Spiral_Matrix_II {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int ans[][] = generateMatrix(A);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans[0].length; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	public static int[][] generateMatrix(int A) {
		int top = 0;
		int bottom = A-1;
		int left = 0;
		int right = A-1;
		int max_count = A*A;
		int mat[][] = new int[A][A];
		int dir = 1;
		int count = 1;
		while( left <= right && top <= bottom){
			if(dir == 1 && max_count>0){
				for(int col=left; col<=right; col++){
					mat[top][col] = count;
					//System.out.println("1 "+mat[top][col]);
					count++;
					max_count--;
				}
				top++;
				dir++;
			}
			if(dir == 2 && max_count>0){
				for(int row = top; row<=bottom; row++){
					mat[row][right] = count;
					//System.out.println("2 "+mat[row][right]);
					count++;
					max_count--;
				}
				right--;
				dir++;
			}
			if(dir == 3 && max_count>0){
				for(int col=right; col>=left; col--){
					mat[bottom][col] = count;
					//System.out.println("3 "+mat[bottom][col]);
					count++;
					max_count--;
				}
				bottom--;
				dir++;
			}
			if(dir == 4 && max_count>0){
				for(int row = bottom; row >= top; row--){
					mat[row][left] = count;
					//System.out.println("4 "+mat[row][left]);
					count++;
					max_count--;
				}
				left++;
				dir=1;
			}
		}
		return mat;
	}
}
