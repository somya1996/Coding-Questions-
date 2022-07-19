package Matrix;

import java.util.Scanner;

public class Max_sum_square_submatrix {
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
		int B = sc.nextInt();
		int max_sum = solve(A , B);
		System.out.println(max_sum);
	}
	public static int solve(int[][] A, int B) {
		int n = A.length;
		int m = A[0].length;
		int mat[][] = prefix_sum(A);
		/*for(int i=0;i< mat.length; i++){
			for(int j=0;j< mat[0].length; j++){
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}*/
		int maxsum = Integer.MIN_VALUE;
		for(int i=0; i<=n-B; i++){
			int sum = 0;
			for(int j=0; j<= m-B; j++){
				if(i == 0 && j == 0){
					sum = mat[i+B-1][j+B-1];
					//System.out.println("i "+i + " j "+j+" sum " +sum);
					maxsum = Math.max(maxsum , sum);
				}
				if(i != 0 && j ==0){
					sum = mat[i+B-1][j+B-1] - mat[i-1][j+B-1];
					//System.out.println("i "+i + " j "+j+" sum " +sum);
					maxsum = Math.max(maxsum , sum);
				}
				if(i ==0 && j != 0){
					sum = mat[i+B-1][j+B-1] - mat[i+B-1][j-1];
					//System.out.println("i "+i + " j "+j+" sum " +sum);
					maxsum = Math.max(maxsum , sum);
				}
				if(i !=0 && j != 0){
					sum = mat[i+B-1][j+B-1] - mat[i-1][j+B-1] - mat[i+B-1][j-1] + mat[i-1][j-1];
					//System.out.println("i "+i + " j "+j+" sum " +sum);
					maxsum = Math.max(maxsum , sum);
				}
			}
		}
		return maxsum;
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
