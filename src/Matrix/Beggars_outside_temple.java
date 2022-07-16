package Matrix;

import java.util.Arrays;
import java.util.Scanner;

public class Beggars_outside_temple {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][3];
		for(int i=0; i<n; i++){
			for(int j=0; j<3; j++)
				arr[i][j] = sc.nextInt();
		}
		int A = sc.nextInt();
		int ans[] = solve(A , arr);
		for(int i=0; i<ans.length; i++){
			System.out.println(ans[i]);
		}
	}
	public static int[] solve(int A, int[][] B) {
		int ans[] = new int[A];

		for(int i=0; i<B.length; i++){
			int start = B[i][0];
			int end = B[i][1];
			int amt = B[i][2];
			for(int j= start-1 ; j<end; j++){
				ans[j] += amt;
			}

		}
		return ans;
	}
}
