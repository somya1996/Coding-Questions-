package GRAPH;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Breadth_first_search_Traversal {
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
		ArrayList<Integer> ans = bfsOfGraph(v , adj);
	}
	/*
-> Generic Function for BFS traversal of a Graph
 (valid for directed as well as undirected graphs
 which can have multiple disconnected components)
-- Inputs --
-> V - represents number of vertices in the Graph
-> adj[] - represents adjacency list for the Graph
-- Output --
-> bfs_traversal - a vector containing bfs traversal
for entire graph
*/

	public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
	{
		ArrayList<Integer>bfs = new ArrayList<Integer>();
		boolean[] vis = new boolean[V];
		Queue<Integer> q = new LinkedList<>();

		q.add(0);
		vis[0] = true;

		while(!q.isEmpty()){
			Integer ele = q.poll();
			bfs.add(ele);

			for(Integer it : adj.get(ele)){
				if(vis[it] == false){
					q.add(it);
					vis[it] = true;
				}
			}
		}
		return bfs;
	}
}
