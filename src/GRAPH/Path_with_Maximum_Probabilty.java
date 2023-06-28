package GRAPH;

import java.util.*;

public class Path_with_Maximum_Probabilty {
	static class Pair{
		int edge;
		double wgt;
		Pair(int l , double w){
			edge = l;
			wgt = w;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] edges = new int[n][2];
		System.out.println("elements of edges");
		for(int i=0; i<n; i++){
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}
		double[] succProb = new double[n];
		System.out.println("elements of succ prob");
		for(int i=0; i<n; i++){
			succProb[i] = sc.nextInt();
		}
		System.out.println("start and end");
		int start = sc.nextInt();
		int end = sc.nextInt();

		double ans = maxProbability(n , edges , succProb , start , end);
	}
	public static double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
		ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<Pair>());
		}
		for (int i = 0; i < edges.length; i++) {
			int u = edges[i][0];
			int v = edges[i][1];
			double p = succProb[i];
			adj.get(u).add(new Pair(v, p));
			adj.get(v).add(new Pair(u, p));
		}
		/**Print adj list*/
		for(int i=0; i<adj.size(); i++){
			System.out.print(adj.get(i));
			for(int j=0; j<adj.get(i).size(); j++){
				System.out.print(adj.get(i).get(j));
			}
			System.out.println();
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		double[] dis = new double[n];
		Arrays.fill(dis,0.0);
		dis[start] = 1.0;

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (Pair p : adj.get(curr)) {
				int edj = p.edge;
				double wt = p.wgt;
				double new_wt = wt * dis[curr];
				if (new_wt > dis[edj]){
					dis[edj] = new_wt;
					q.add(edj);
				}
			}
		}
		return dis[end];

		/**
		 * double[] dist = new double[n];
		 *         Arrays.fill(dist, 0.0);
		 *         dist[start] = 1.0;
		 *
		 *         // Queue for BFS
		 *         Queue<Integer> queue = new LinkedList<>();
		 *         queue.offer(start);
		 *
		 *         while (!queue.isEmpty()) {
		 *             int curr = queue.poll();
		 *
		 *             for (Pair<Integer, Double> pair : adj.get(curr)) {
		 *                 int node = pair.getKey();
		 *                 double prob = pair.getValue();
		 *                 double newProb = dist[curr] * prob;
		 *
		 *                 if (newProb > dist[node]) {
		 *                     dist[node] = newProb;
		 *                     queue.offer(node);
		 *                 }
		 *             }
		 *         }
		 *
		 *         return dist[end];
		 */
	}
}
