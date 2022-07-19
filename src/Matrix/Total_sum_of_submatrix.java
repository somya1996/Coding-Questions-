package Matrix;

import groovy.json.JsonToken;

import java.util.Scanner;

public class Total_sum_of_submatrix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[][] = new int[n][n];
		for(int i=0; i<n ; i++){
			for(int j=0;  j<n; j++){
				A[i][j] = sc.nextInt();
			}
		}
		int total_submatrix = sum_sub_matrix(A);
		System.out.println(total_submatrix);
	}
	public static int sum_sub_matrix(int[][] A){
		// Brute force O(n^6)
		/*
		int n = A.length;
		int sum = 0;
		for(int x1=0; x1<n; x1++){
			for(int y1=0; y1<n; y1++){
				for(int x2 = 0; x2 < n; x2++){
					for(int y2 = 0; y2 < n; y2++){
						for(int i=x1; i <= y1; i++){
							for(int j = x2; j <= y2; j++){
								sum += A[i][j];
							}
						}
					}
				}
			}
		}
		return sum;

	*/
	// prefix sum
	// Generate all sub matrix + Prefix sum =>  O(n^4)*O(1)

		// OPtimal approach
		int n = A.length;
		int sum = 0;
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				sum += A[i][j]*(i+1)*(j+1)*(n-i)*(n-j);
			}
		}
		return sum;
	}
}
