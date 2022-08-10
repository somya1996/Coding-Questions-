package Matrix;
import java.util.Scanner;

public class Power_of_matrix {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int mat[][] = new int[n][n];

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				mat[i][j] = sc.nextInt();
			}
		}

		int power = sc.nextInt();

		int[][] ans = power_of_matrix(mat , power);
		for(int i=0; i<ans.length; i++){
			for(int j=0; j<ans.length; j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static int[][] power_of_matrix(int[][] mat , int power){
		/*if(power == 1)
			return mat;
		int ans[][] = power_of_matrix(mat , power/2);
		if(power%2 == 0){
			return multiply_mat(ans , ans);
		}
		else
			return multiply_mat(ans , multiply_mat(ans , mat));

		*/
		int res [][] = {{1,0},{0,1}}; // this is used when want to return same ans
		while(power > 0){
			if(power%2 != 0 )
				res = multiply_mat(res , mat);
			mat = multiply_mat(mat,mat);
			power /= 2;
		}
		return  res;
	}
	public static int[][] multiply_mat(int[][] mat1 , int[][] mat2){
		int ans[][] = new int[mat1.length][mat2.length];
		for(int i=0; i<mat1.length; i++){
			for(int j=0; j< mat1.length; j++){
				for(int k = 0; k<mat1[0].length; k++) {
					ans[i][j] += mat1[i][k]*mat2[k][j];
				}
			}
		}
		return ans;
	}
}
