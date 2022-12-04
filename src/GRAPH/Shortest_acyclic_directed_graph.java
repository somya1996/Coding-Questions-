package GRAPH;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Shortest_acyclic_directed_graph {
	class Pair{
		int first;
		int second;
		Pair(int n , int wt){
			first = n;
			second = wt;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int[][] edges = new int[n][3];
		for(int i=0; i<edges.length; i++){
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		Shortest_acyclic_directed_graph sadg = new Shortest_acyclic_directed_graph();
		int[] ans = sadg.shortestPath(vertices , n , edges);
		for(int i=0; i<ans.length; i++){
			System.out.print(ans[i]+" ");
		}
	}
	public int[] shortestPath(int vertices, int N, int[][] edges) {
		ArrayList<ArrayList<Pair>> adjlist = new ArrayList<ArrayList<Pair>>();
		for(int i=0; i<=vertices; i++){
			ArrayList<Pair>temp = new ArrayList<>();
			adjlist.add(temp);
		}
		for(int i=0; i<edges.length; i++){
			int src = edges[i][0];
			int dest = edges[i][1];
			int wt = edges[i][2];
			adjlist.get(src).add(new Pair(dest , wt));
		}
		int[] visited = new int[vertices+1];
		Stack<Integer> st = new Stack<Integer>();
		for(int i=0; i<=vertices; i++){
			if(visited[i] == 0){
				toposort(i , adjlist , visited , st);
			}
		}
		int[] distance = new int[vertices];
		Arrays.fill(distance , Integer.MAX_VALUE);

		distance[0] = 0;
		while(!st.isEmpty()){
			int node = st.pop();
			for(int i=0; i<adjlist.get(node).size(); i++){
				int destination = adjlist.get(node).get(i).first;
				int weight = adjlist.get(node).get(i).second;

				if(distance[destination] > distance[node]+weight){
					distance[destination] = distance[node]+weight;
				}
			}
		}
		return distance;
	}
	public void toposort(int node , ArrayList<ArrayList<Pair>> adjlist , int[] vis , Stack<Integer>st){
		vis[node] = 1;
		for(Pair nbr : adjlist.get(node)){
			int v = nbr.first;
			if(vis[v] == 0)
				toposort(v , adjlist , vis , st);
		}
		st.add(node);
	}
}
