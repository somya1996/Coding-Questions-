package Matrix;

import java.util.Scanner;

public class Binary_search_in_matrix {
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
		System.out.println(B_present_in_matrix(A , B));

	}
	public static String B_present_in_matrix(int[][] A , int B){
		int i =0,j=A[0].length-1;
		while(i<A.length && j>=0)
		{
			if(A[i][j]==B)
			{
				return i+" "+j;
			}
			else if(B>A[i][j])
				i++;
			else
				j--;
		}
		return "-1";
	}
}
