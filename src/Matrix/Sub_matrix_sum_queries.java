package Matrix;

import java.util.Scanner;

public class Sub_matrix_sum_queries {
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
		System.out.println("B two elements ");
		int[] B = new int[2];
		B[0] = sc.nextInt();
		B[1] = sc.nextInt();

		System.out.println("C two elements ");
		int[] C = new int[2];
		C[0] = sc.nextInt();
		C[1] = sc.nextInt();

		System.out.println("D two elements ");
		int[] D = new int[2];
		D[0] = sc.nextInt();
		D[1] = sc.nextInt();

		System.out.println("E two elements ");
		int[] E = new int[2];
		E[0] = sc.nextInt();
		E[1] = sc.nextInt();

		int ans[] = solve(A , B , C , D , E);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
		int[] ans = new int[B.length];
		long[][] mat = new long[A.length][A[0].length];
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
		for(int i=0 ; i<B.length; i++){
			// start
			int x1 = B[i]-1;
			int x2 = D[i]-1;
			// end
			int y1 = C[i]-1;
			int y2 = E[i]-1;

			long sum = 0;

			if(x1 == 0 && y1 == 0)
				sum = mat[x2][y2];
			if(x1 !=0 && y1 != 0){
				sum = mat[x2][y2] - mat[x1-1][y2] - mat[x2][y1-1] + mat[x1-1][y1-1];
			}
			if(x1 == 0 && y1 != 0){
				sum = mat[x2][y2] - mat[x2][y1 - 1];
			}
			if(x1 != 0 && y1 == 0){
				sum = mat[x2][y2] - mat[x1 - 1][y2];
			}
			int mod = 1000000007;
			while(sum < 0){
				sum += mod;
			}
			sum = sum % mod;
			ans[i] = (int)sum;
		}
		return ans;
	}
}
