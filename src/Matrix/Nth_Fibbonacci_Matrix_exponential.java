package Matrix;
import java.util.Scanner;
//using matrix exponential
public class Nth_Fibbonacci_Matrix_exponential {
	public static void main(String args[]){
		// TC = O(log n)
		// SC = O(log n)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = fibonacciNumber(n);
		System.out.println(ans);
	}
	public static int fibonacciNumber(int n){
		long mod = (int)1000000007;
		int mat[][] = {{1 , 1},{1 , 0}};
		int [][] ans = fib_func(mat , n);
		return (int)(ans[0][1]%mod);
	}

	public static int[][] fib_func(int[][]mat , int n){
		if( n == 1)
			return mat;
		int ans[][] = fib_func(mat , n/2);
		if(n%2 == 0){
			return multiply_mat(ans , ans);
		}
		else
			return multiply_mat(ans , multiply_mat(ans , mat));
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
