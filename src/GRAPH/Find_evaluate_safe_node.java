package GRAPH;

import java.util.*;

public class Find_evaluate_safe_node {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int matrix[][] = new int[n][2];
		for(int i=0; i< matrix.length; i++){
			matrix[i][0] = sc.nextInt();
			matrix[i][1] = sc.nextInt();
		}
		List<Integer> ans = eventualSafeNodes(matrix);
		for(int i=0; i<ans.size(); i++)
			System.out.print(ans.get(i)+" ");
	}
	public static List<Integer> eventualSafeNodes(int[][] graph) {
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<graph.length; i++){
			adjlist.add(new ArrayList<Integer>());
		}
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length; j++)
				adjlist.get(graph[i][j]).add(i);
		}
		int[] indegree = new int[graph.length];
		for(int i=0; i<adjlist.size(); i++){
			for(Integer it : adjlist.get(i)){
				indegree[it]++;
			}
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<indegree.length; i++){
			if(indegree[i] == 0){
				q.add(i);
			}
		}
		List<Integer> ans = new ArrayList<Integer>();
		while(!q.isEmpty()){
			int node = q.poll();
			ans.add(node);
			for(int it : adjlist.get(node)){
				indegree[it]--;
				if(indegree[it] == 0){
					q.add(it);
				}
			}
		}
		Collections.sort(ans);
		return ans;
	}
}
