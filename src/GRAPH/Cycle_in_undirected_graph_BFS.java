package GRAPH;

import java.util.*;

public class Cycle_in_undirected_graph_BFS {
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
				if(check_cycle(i , adjlist , vis) == 1)
					return 1;
			}
		}
		return 0;
	}
	class Pair{
		int first;
		int second;
		Pair(int f , int s){
			first = f;
			second = s;
		}
	}
	public int check_cycle(int src , ArrayList<ArrayList<Integer>> adjlist , int[] vis){
		vis[src] = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(src , -1));

		while(!q.isEmpty()){
			Pair p  = q.poll();
			int node = p.first;
			int parent = p.second;

			for(Integer it : adjlist.get(node)){
				if(vis[it] == 0){
					q.add(new Pair(it , node));
					vis[it] = 1;
				}

				else if(parent != it)
						return 1;

			}
		}
		return 0;
	}
}