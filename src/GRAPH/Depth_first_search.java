package GRAPH;

import java.util.ArrayList;
import java.util.Scanner;

public class Depth_first_search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for(int i=0; i<v; i++){
			adj.add(new ArrayList<>());
			int n = sc.nextInt();
			for(int j=0; j<n; j++){
				adj.get(i).add(sc.nextInt());
			}
		}
		ArrayList<Integer> ans = dfsOfGraph(v , adj);
	}
	public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] vis = new boolean[V+1];
		vis[0] = true;
		dfs(0 , vis , adj , list);
		return list;
	}
	public static void dfs(int node , boolean[] vis , ArrayList<ArrayList<Integer>>adj , ArrayList<Integer>list){
		vis[node] = true;
		list.add(node);

		for(Integer it : adj.get(node)){
			if(vis[it] == false)
				dfs(it , vis , adj , list);
		}
	}
}
