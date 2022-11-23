package GRAPH;

import java.util.ArrayList;
import java.util.Scanner;

public class Number_of_provinces_using_BFS {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[][] = new int[n][n];
		for(int i = 0; i<n; i++){
			for(int j=0; j<n; j++){
				A[i][j] = sc.nextInt();
			}
		}
		int ans = find_unique_graph(A);
		System.out.println(ans);
	}
	public static int find_unique_graph(int[][] isConnected) {
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<isConnected.length; i++){
			adjlist.add(new ArrayList<Integer>());
		}
		for(int i=0; i<isConnected.length; i++){
			for(int j=0; j<isConnected.length; j++){
				if(isConnected[i][j] == 1 && i!=j){
					adjlist.get(i).add(j);
					adjlist.get(j).add(i);
				}
			}
		}
		boolean[] vis = new boolean[isConnected.length];
		int count = 0;
		for(int i=0; i<isConnected.length; i++){
			if(vis[i] == false){
				count++;
				dfs(i , vis , adjlist);
			}
		}
		return count;
	}
	public static void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>> adjlist){
		vis[node] = true;
		for(Integer it : adjlist.get(node)){
			if(vis[it] == false)
				dfs(it , vis , adjlist);
		}
	}
}
