package GRAPH;

import java.util.PriorityQueue;
import java.util.Scanner;
// using Prims Algorithm
public class Damages_roads {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int B[] = new int[m];
		for(int i=0; i<m; i++){
			B[i] = sc.nextInt();
		}
		Damages_roads dr = new Damages_roads();
		int ans = dr.solve(A , B);
		System.out.println(ans);
	}
	class Pair{
		int cost;
		int x_axis;
		int y_axis;
		Pair(int c , int i , int j){
			cost = c;
			x_axis = i;
			y_axis = j;
		}
	}
	public int solve(int[] A, int[] B) {
		int n = A.length;
		int m = B.length;

		int[][] grid = new int[n+1][m+1];
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x,y)->x.cost - y.cost);
		pq.add(new Pair(0 , 0 , 0));
		int totalcost = 0;

		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int c = p.cost;
			int i = p.x_axis;
			int j = p.y_axis;


			if(grid[i][j] != 0) continue;

			grid[i][j] = c;
			totalcost += c;
			System.out.println(i+" "+j+" "+c);
			if(i<n){
				pq.add(new Pair(A[i] , i+1 , j));
			}
			if(j<m){
				pq.add(new Pair(B[j] , i , j+1));
			}
		}
		for(int i=0;i<=n; i++){
			for(int j=0; j<=m; j++){
				System.out.print(grid[i][j]+" ");
			}
			System.out.println();
		}
		return totalcost;
	}
}
