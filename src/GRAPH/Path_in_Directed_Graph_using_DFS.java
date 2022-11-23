package GRAPH;

import java.util.ArrayList;
import java.util.Scanner;

public class Path_in_Directed_Graph_using_DFS {
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
	public static int solve(int V , int[][] A){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();

		for(int i=0; i<=V; i++)
			adjlist.add(new ArrayList<>());

		// fill adj list from B matrix
		for(int i=0; i<A.length; i++){
			adjlist.get(A[i][0]).add(A[i][1]);
		}

		int[] vis = new int[V+1];

		return dfs(1 , adjlist , vis , V);

	}
	public static int dfs(int node , ArrayList<ArrayList<Integer>> adjlist , int[] vis , int dest){
		if(node == dest)
			return 1;
		vis[node] = 1;
		for(Integer it : adjlist.get(node)){
			if(vis[it] == 0)
				if(dfs(it , adjlist , vis , dest) == 1)
					return 1;
			else
				return 0;
		}
		return 0;
	}
}
