package Sorting_Techniques.Medium;

import java.util.Scanner;

public class Matrix_search {
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

		int target = sc.nextInt();
		// if found return 1 else 0;
		int ans = searchMatrix(arr , target);
		System.out.println(ans);
	}
	public static int searchMatrix(int[][] A, int B) {
		int row = A.length;
		int col = A[0].length;
		int start = 0 , end = (row*col)-1;
		while(start <= end){
			int mid = (start+end)/2;
			int ith_row = mid/col;
			int ith_col = mid%col;
			if(A[ith_row][ith_col] == B)
				return 1;
			else if(A[ith_row][ith_col] < B)
				start = mid+1;
			else
				end = mid-1;
		}
		return 0;
	}
}
