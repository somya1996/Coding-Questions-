package GRAPH;

import java.util.*;

public class Topological_Kahns_Algorithm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];
		for(int i=0; i< matrix.length; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		Topological_Kahns_Algorithm tka = new Topological_Kahns_Algorithm();
		int ans[] = tka.solve(vertices , matrix);
		for(int i=0; i<ans.length; i++)
			System.out.print(ans[i]+" ");
	}
	public int[] solve(int vertices , int[][] matrix){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
		for(int i=0; i<=vertices; i++){
			adjlist.add(new ArrayList<>());
		}
		for(int i=0; i<matrix.length; i++){
			adjlist.get(matrix[i][0]).add(matrix[i][1]);
		}

		int[] indegree = new int[vertices+1];
		Arrays.fill(indegree, 0);

		for(int i=1; i<=vertices; i++){
			for(Integer nbr : adjlist.get(i)){
				indegree[nbr]++;
			}
		}

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for(int i=1; i<=vertices; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()){
			int node = q.poll();
			ans.add(node);
			for(Integer nbr : adjlist.get(node)){
				indegree[nbr] -= 1;
				if(indegree[nbr] == 0){
					q.add(nbr);
				}
			}
		}
		int arr[] = new int[ans.size()];
		for(int i=0; i<ans.size(); i++){
			arr[i] = ans.get(i);
		}
		return arr;
	}
}
