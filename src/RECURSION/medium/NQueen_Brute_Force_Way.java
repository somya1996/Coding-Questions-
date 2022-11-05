package RECURSION.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class NQueen_Brute_Force_Way{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		NQueen_Brute_Force_Way Nqb = new NQueen_Brute_Force_Way();
		ArrayList<ArrayList<String>> ans = Nqb.solveNQueens(n);
		System.out.println(ans);
	}
	public ArrayList<ArrayList<String>> solveNQueens(int n) {
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		char visited[][] = new char[n][n];
		for(char rows[]: visited){
			Arrays.fill(rows,'.');
		}
		search_ways_for_Queen(0 , visited , ans);
		return ans;
	}
	public void search_ways_for_Queen(int col , char[][]visited , ArrayList<ArrayList<String>>ans){
		if(col == visited.length){
			ans.add(construct(visited));
			return;
		}
		for(int row = 0; row< visited.length; row++){
			if(isSafe(row , col , visited)){
				visited[row][col] = 'Q';
				search_ways_for_Queen(col+1 , visited , ans);
				visited[row][col] = '.';
			}
		}
	}
	public ArrayList<String> construct(char[][] visited){
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0; i<visited.length; i++){
			String s = new String(visited[i]);
			//System.out.println(s);
			ans.add(s);
		}
		return ans;
	}
	public boolean isSafe(int row , int col , char[][] visited){
		// istead of going in forwar direction and marking the elements as marked
		// we will the particular box is safe to mark as visited so we check in backward direction is any queen placed?
		int r = row;
		int c = col;
		// its previous diagonals(upward direction) should be clear
		while(r>=0 && c>=0){
			if(visited[r][c] == 'Q') return false;
			r--;
			c--;
		}
		r = row ; c = col;
		// check elements of same row diff column
		while(c >= 0){
			if(visited[r][c]=='Q') return false;
			c--;
		}
		r = row; c = col;
		//its previous diagonals(downward direction)should be clear
		while(c>=0 && r<visited.length){
			if(visited[r][c]=='Q')return false;
			r++;
			c--;
		}
		return true;
	}
}
