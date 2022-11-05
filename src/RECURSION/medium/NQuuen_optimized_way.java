package RECURSION.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class NQuuen_optimized_way {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<String>> ans = solveNQueen(n);
		System.out.println(ans);
	}

	public static ArrayList<ArrayList<String>> solveNQueen(int n){
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		char[][] board = new char[n][n];
		for(int i=0; i<n; i++){
			for(int j =0; j<n; j++){
				board[i][j] = '.';
			}
		}
		int[] leftRow = new int[n];
		Arrays.fill(leftRow , 0);

		int[] upperdiagonals = new int[2*n-1];
		Arrays.fill(upperdiagonals , 0);

		int[] lowerdiagonals = new int[2*n-1];
		Arrays.fill(lowerdiagonals , 0);

		Queen_ways(0 , board , ans , leftRow , lowerdiagonals , upperdiagonals);
		return ans;
	}

	public static void Queen_ways(int col , char[][]board , ArrayList<ArrayList<String>> ans , int[]leftRow ,
	                       int[]lowerDiagonal , int[]upperDiagonal) {
		if (col == board.length) {
			ans.add(construct(board));
			return;
		}
		for (int row = 0; row < board.length; row++) {
			if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
				board[row][col] = 'Q';
				leftRow[row] = 1;
				lowerDiagonal[row + col] = 1;
				upperDiagonal[board.length - 1 + col - row] = 1;
				Queen_ways(col + 1, board, ans, leftRow, lowerDiagonal, upperDiagonal);
				board[row][col] = '.';
				leftRow[row] = 0;
				lowerDiagonal[row + col] = 0;
				upperDiagonal[board.length - 1 + col - row] = 0;
			}
		}
	}
	public static ArrayList< String > construct(char[][] board) {
		ArrayList < String > res = new ArrayList< String > ();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}
