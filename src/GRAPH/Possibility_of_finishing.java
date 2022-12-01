package GRAPH;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Possibility_of_finishing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();

		int n = sc.nextInt();
		int[] B = new int[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}

		int C[] = new int[n];
		for(int i=0; i<n; i++){
			C[i] = sc.nextInt();
		}
		Possibility_of_finishing pf = new Possibility_of_finishing();
		int ans = pf.solve(vertices , B , C);
		System.out.println(ans);
	}
	public int solve(int vertices , int[] B, int[] C) {
		int[] vis = new int[vertices+1];
		ArrayList<ArrayList<Integer>> adjlist = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<= vertices; i++){
			adjlist.add(new ArrayList<>());
		}
		for(int i=0; i<B.length; i++){
			adjlist.get(B[i]).add(C[i]);
		}
		boolean f = false;
		for(int i=1; i<=vertices; i++){
			if(vis[i] == 0){
				check_cycle(i , vis , adjlist , f);
				if(f == false)
					return 0;
			}
		}
		return 1;
	}
	public static void check_cycle(int node , int[] vis , ArrayList<ArrayList<Integer>> adjlist , boolean f){
		vis[node] = 1;
		for(Integer nbr : adjlist.get(node)){
			if(vis[nbr] == 0){
				check_cycle(nbr , vis , adjlist , f);
			}
			else if(vis[nbr] == 1)
				f = true;
		}
		vis[node] = 2;
	}
}
