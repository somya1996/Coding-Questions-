package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cycle_in_undirected_graph_DFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];

		for(int i=0; i<n; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		Cycle_in_undirected_graph_BFS ciug = new Cycle_in_undirected_graph_BFS();
		int ans = ciug.solve(vertices , matrix);
		System.out.println(ans);
	}

	public int solve(int vertices , int[][] matrix) {
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
		for(int i=0; i<=vertices; i++)
			adjlist.add(new ArrayList<Integer>());
		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
			adjlist.get(matrix[i][1]).add(matrix[i][0]);
		}
		System.out.println(adjlist);

		int vis[] = new int[vertices+1];
		Arrays.fill(vis , 0);
		for(int i=0; i<=vertices; i++){
			if(vis[i] == 0){
				if(check_cycle_dfs(i ,-1, adjlist , vis) == 1)
					return 1;
			}
		}
		return 0;
	}
	public int check_cycle_dfs(int node , int parent , ArrayList<ArrayList<Integer>> adjlist , int[] vis){
		vis[node] = 1;
		for(Integer adjacentNode : adjlist.get(node)){
			if(vis[adjacentNode] == 0){
				if(check_cycle_dfs(adjacentNode , node , adjlist , vis) == 1)
					return 1;
			}
			else
				if(adjacentNode != parent)
					return 1;
		}
		return 0;
	}
}
