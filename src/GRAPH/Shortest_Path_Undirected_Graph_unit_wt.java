package GRAPH;

import java.util.*;

public class Shortest_Path_Undirected_Graph_unit_wt {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//int vertices = sc.nextInt();
		//int n = sc.nextInt();
		//int[][] edges = new int[n][3];
		//for(int i=0; i<edges.length; i++){
		//	edges[i][0] = sc.nextInt();
		//	edges[i][1] = sc.nextInt();
		//}
		int n=9, m=10;
		int[][] edge = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
		Shortest_Path_Undirected_Graph_unit_wt sh = new Shortest_Path_Undirected_Graph_unit_wt();
		int[] ans = sh.shortestPath(n , m , edge);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	class Pair{
		int first;
		int second;
		Pair(int f , int s){
			first = f;
			second = s;
		}
	}
	public int[] shortestPath(int vertices , int n , int[][]edges){
		ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=vertices; i++){
			adj.add(new ArrayList<>());
		}
		for(int i=0; i<n; i++){
			adj.get(edges[i][0]).add(edges[i][1]);
			adj.get(edges[i][1]).add(edges[i][0]);
		}
		int[] dist = new int[vertices];
		Arrays.fill(dist , Integer.MAX_VALUE);
		dist[0] = 0;

		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(0 , 0));

		while(!q.isEmpty()){
			Pair p = q.poll();
			int node = p.first;
			int distance = p.second;
			for(Integer it : adj.get(node)){
				if (distance + 1 < dist[it]){
					dist[it] = distance+1;
					q.add(new Pair(it , dist[it]));
				}
			}
		}
		for(int i=0; i<dist.length; i++){
			if(dist[i] == Integer.MAX_VALUE)
				dist[i] = -1;
		}
		return dist;
	}
}
