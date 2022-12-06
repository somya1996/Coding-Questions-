package GRAPH;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Minimum_spanning_tree<sortweight> {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();

		int n = sc.nextInt();
		int matrix[][] = new int[n][3];
		for(int i=0; i<n; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
			matrix[i][2] = sc.nextInt();
		}
		Minimum_spanning_tree mst = new Minimum_spanning_tree();
		int ans = mst.solve(vertices , matrix);
		System.out.println(ans);
	}
	class Pair{
		int node;
		int weight;
		Pair(int wt , int n){
			weight = wt;
			node = n;
		}
	}
	class sortweight implements Comparator<Pair>{
		@Override
		public int compare(Pair o1, Pair o2) {
			return o1.weight - o2.weight;
		}
	}

	public int solve(int vertices, int[][] matrix) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
		for(int i=0; i<= vertices; i++){
			adj.add(new ArrayList<Pair>());
		}
		for(int i=0; i<matrix.length; i++){
			int src = matrix[i][0];
			int dest = matrix[i][1];
			int wt = matrix[i][2];
			adj.get(src).add(new Pair(wt , dest));
			adj.get(dest).add(new Pair(wt , src));
		}
		//System.out.println(adj);
		for(int i=0; i<adj.size(); i++){
			for(int j=0; j<adj.get(i).size(); j++){
				System.out.println(adj.get(i).get(j).node + " "+ adj.get(i).get(j).weight);
			}
			System.out.println();
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x , y)->x.weight - y.weight);
		int[] vis = new int[vertices+1];
		pq.add(new Pair(0 , 1));
		int sum = 0;

		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int wt = p.weight;
			int node = p.node;

			if(vis[node] == 1) continue;

			vis[node] = 1;
			sum += wt;

			for(int i=0; i<adj.get(node).size(); i++){
				int edgewt = adj.get(node).get(i).weight;
				int adjnode = adj.get(node).get(i).node;
				if(vis[adjnode] == 0){
					pq.add(new Pair(edgewt , adjnode));
				}
			}
		}
		return sum;
	}
}
