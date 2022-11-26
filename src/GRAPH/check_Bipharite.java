package GRAPH;

import java.util.*;

public class check_Bipharite {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];

		for (int i = 0; i < n; i++) {
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		check_Bipharite cb = new check_Bipharite();
		int ans = cb.solve(vertices , matrix);
		System.out.println(ans);
	}
	public int solve(int vertices , int[][] matrix){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=vertices; i++)
			adjlist.add(new ArrayList<>());

		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
			adjlist.get(matrix[i][1]).add(matrix[i][0]);
		}
		int color[] = new int[vertices+1];
		Arrays.fill(color , -1);

		for(int i=1; i<vertices; i++){
			if(color[i] == -1){
				if(check_Bipharite(i , color , adjlist) == true)
					return 1;
			}
		}
		return 0;
	}
	public boolean check_Bipharite(int src , int[] color , ArrayList<ArrayList<Integer>> adjlist){
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		color[src] = 0;

		while(!q.isEmpty()){
			int node = q.poll();
			for(Integer it : adjlist.get(node)){
				if(color[it] == -1){
					q.add(it);
					color[it] = 1-color[node];
				}
				else
					if(color[it] == color[node])
						return false;
			}
		}
		return true;
	}
}
