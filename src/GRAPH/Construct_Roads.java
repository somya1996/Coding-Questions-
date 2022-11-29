package GRAPH;

import java.util.*;

public class Construct_Roads {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		Construct_Roads cr = new Construct_Roads();
		int ans = cr.solve(vertices , matrix);
		System.out.println(ans);
	}
	public static int solve(int vertices , int[][] matrix){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=vertices; i++)
			adjlist.add(new ArrayList<>());

		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
			adjlist.get(matrix[i][1]).add(matrix[i][0]);
		}
		int color[] = new int[vertices+1];
		Arrays.fill(color , -1);

		int[] parent = new int[vertices+1];
		Arrays.fill(parent , 0);

		//int count = 0;
		int max_count = 0;

		for(int i=0; i<= vertices; i++){
			int count = 0;
			if(color[i] == -1){
				if(check_bhipharite_bfs(i , color , adjlist ,  parent) == true){
					count = no_of_edge(color , parent);
				}
			}
			max_count = Math.max(max_count , count);
		}
		return max_count;
	}
	public static boolean check_bhipharite_bfs(int src , int[] color , ArrayList<ArrayList<Integer>> adjlist , int[] parent){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		color[src] = 0;
		parent[src] = -1;
		while(!q.isEmpty()){
			int node = q.poll();
			for(Integer it : adjlist.get(node)){
				if(color[it] == -1){
					q.add(it);
					color[it] = 1-color[node];
					parent[it] = node;
				}
				else
					if(color[it] == color[node])
						return false;
			}
		}
		return true;
	}
	public static int no_of_edge(int[] color , int[] parent){
		int count =  0;
		for (int i=color.length-1; i>0 ; i--){
			for (int j=i-1; j>0 ; j--){
				if(color[i] != color[j]){
					if(parent[i]!= j && parent[j] != i) {
						//System.out.println("i "+i+" j "+j);
						count++;
					}
				}
			}
		}
		return count;
	}
}
