package GRAPH;

import java.util.*;

public class Alien_dictionary {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();

		int n = sc.nextInt();
		String[] str = new String[n];
		for(int i=0; i<n; i++){
			str[i] = sc.nextLine();
		}

		String ans = findOrder(str , n , vertices);
	}
	public static String findOrder(String [] dict, int N, int K){
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<>();
		for(int i=0; i<K; i++){
			adjlist.add(new ArrayList<>());
		}
		for(int i=0; i<dict.length-1; i++){
			String s1 = dict[i];
			String s2 = dict[i+1];
			int len = Math.min(s1.length() , s2.length());
			for(int j=0; j<len; j++){
				if(s1.charAt(j) != s2.charAt(j+1)){
					adjlist.get(s1.charAt(j)-'a').add(s2.charAt(j) - 'a');
					break;
				}
			}
		}

		List<Integer> topo = topological_sort(K, adjlist);
		String ans = "";
		for (int it : topo) {
			ans = ans + (char)(it + (int)('a'));
		}
		return ans;
	}
	public static List<Integer> topological_sort(int vertices , ArrayList<ArrayList<Integer>> adjlist){
		int indegree[] = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			for (int it : adjlist.get(i)) {
				indegree[it]++;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < vertices; i++) {
			if (indegree[i] == 0) {
				q.add(i);
			}
		}
		List<Integer> topo = new ArrayList<>();
		while (!q.isEmpty()) {
			int node = q.peek();
			q.remove();
			topo.add(node);
			// node is in your topo sort
			// so please remove it from the indegree

			for (int it : adjlist.get(node)) {
				indegree[it]--;
				if (indegree[it] == 0) q.add(it);
			}
		}

		return topo;
	}
}
