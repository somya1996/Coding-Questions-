package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Path_in_Directed_Graph{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int A[][] = new int[n][2];
		for(int i=0; i<n; i++){
			A[i][0] = sc.nextInt();
			A[i][1] = sc.nextInt();
		}
		int ans = solve(vertices , A);
		System.out.println(ans);
	}
	public static int solve(int A, int[][] B) {
		// make adj list
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=A; i++)
			adjlist.add(new ArrayList<>());
		// fill adj list from B matrix
		for(int i=0; i<B.length; i++){
			adjlist.get(B[i][0]).add(B[i][1]);
		}
		// vis array
		int[] vis = new int[A+1];

		Queue<Integer>q = new LinkedList<>();
		q.add(1);
		vis[1] = 1;

		while(!q.isEmpty()){
			int node = q.poll();

			for(Integer it: adjlist.get(node)){
				if(it == A )
					return 1;
				if(vis[it] == 0){
					q.add(it);
					vis[it] = 1;
				}
			}
		}
		return 0;
	}
}
