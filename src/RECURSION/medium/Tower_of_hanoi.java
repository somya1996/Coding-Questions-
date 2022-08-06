package RECURSION.medium;

import java.util.ArrayList;
import java.util.Scanner;

public class Tower_of_hanoi {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [][] ans = towerOfHanoi(n);
		for(int i=0; i<ans.length ; i++){
			for(int j = 0 ; j < 3 ; j++){
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
	static int ans [][];
	static int move = 0;
	public static int[][] towerOfHanoi(int A) {
		int moves = (1<<A)-1;
		int s = 1;
		int h = 2;
		int d = 3;
		ans = new int[moves][3];
		solve( A , s , h , d);
		return ans;
	}
	public static void solve(int n , int s , int h , int d){
		if( n == 0){
			return;
		}
		solve(n-1 , s , d , h );
		ans[move++] = new int[]{n , s , d};
		solve(n-1 , h , s , d);
		return;
	}
}
