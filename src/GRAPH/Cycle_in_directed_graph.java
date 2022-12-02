package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cycle_in_directed_graph {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];

		for(int i=0; i<n; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		Cycle_in_directed_graph cidg = new Cycle_in_directed_graph();
		int ans = cidg.solve(vertices , matrix);
		System.out.println(ans);
	}
	public static int solve(int vertices , int matrix[][]){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=vertices; i++){
			adjlist.add(new ArrayList<>());
		}
		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
		}

		int[] visited = new int[vertices+1];
		Arrays.fill(visited , 0);

		int[] dfsvis = new int[vertices+1];
		Arrays.fill(dfsvis , 0);

		for(int i=0; i<=vertices; i++){
			if(visited[i] == 0){
				if(detect_cycle(i , adjlist , visited , dfsvis)==true)
					return 1;
			}
		}
		return 0;
	}
	public static boolean detect_cycle(int node , ArrayList<ArrayList<Integer>>adjlist , int[]visited , int[]dfsvis){
		visited[node] = 1;
		dfsvis[node] = 1;
		for(Integer it : adjlist.get(node)){
			if(visited[it] == 0) {
				if (detect_cycle(it, adjlist, visited, dfsvis) == true) {
					return true;
				}
			}
			else if(dfsvis[it] == 1) {
				return true;
			}
		}
		dfsvis[node] = 0;
		return false;
	}
}
