package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Batches {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();

		int n = sc.nextInt();
		int[] strength = new int[n];
		for(int i=0; i<n; i++){
			strength[i] = sc.nextInt();
		}

		int m = sc.nextInt();
		int relation[][] = new int[m][2];
		for(int i=0; i<relation.length; i++){
			relation[i][0] = sc.nextInt();
			relation[i][1] = sc.nextInt();
		}

		int limit = sc.nextInt();
		int ans = solve(vertices , strength , relation , limit);
		System.out.println(ans);
	}
	public static int solve(int vertices, int[] strength, int[][] relation, int limit) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=vertices; i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<relation.length; i++){
			adj.get(relation[i][0]).add(relation[i][1]);
			adj.get(relation[i][1]).add(relation[i][0]);
		}

		boolean[] visited = new boolean[vertices+1];
		Arrays.fill(visited , false);

		int count = 0;
		for(int i=1; i<=vertices; i++){
			if(visited[i] == false){
				int batch_strength = dfs(i , strength , adj , visited);
				if(batch_strength >= limit){
					count++;
				}
			}
		}
		return count;
	}
	public static int dfs(int node, int[] strength, ArrayList<ArrayList<Integer>>adj, boolean[]visited){
		visited[node] = true;
		int sum = strength[node-1];
		for(Integer neighbour : adj.get(node)){
			if(visited[node] == false){
				sum += dfs(neighbour , strength , adj , visited);
			}
		}
		return sum;
	}
}
