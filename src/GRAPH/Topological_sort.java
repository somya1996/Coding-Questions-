package GRAPH;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Topological_sort {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];
		for(int i=0; i< matrix.length; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}

		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
		for(int i=0; i<=vertices; i++){
			adjlist.add(new ArrayList<>());
		}
		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
		}

		int[] ans = topoSort(vertices , adjlist);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+ " ");
	}
	static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj)
	{
		int[] vis = new int[V];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<V; i++){
			if(vis[i] == 0)
				dfs(i , vis , st , adj);
		}
		int[] ans = new int[V];
		int j = 0;
		while(!st.isEmpty()){
			ans[j++] = st.peek();
			st.pop();
		}
		return ans;
	}
	private static void dfs(int node, int vis[], Stack<Integer> st, ArrayList<ArrayList<Integer>> adj){
		vis[node] = 1;
		for (int it : adj.get(node)) {
			if (vis[it] == 0)
				dfs(it, vis, st, adj);
		}
		st.push(node);
	}
}
