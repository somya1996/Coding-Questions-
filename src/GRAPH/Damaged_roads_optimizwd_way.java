package GRAPH;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Damaged_roads_optimizwd_way {
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
		Damaged_roads_optimizwd_way drow = new Damaged_roads_optimizwd_way();
		int ans = drow.solve(A , B);
		System.out.println(ans);
	}
	public int solve(int[] A, int[] B){
		int mod = (int)1000000007;
		int n = A.length;
		int m = B.length;
		ArrayList<Pair> arr = new ArrayList<Pair>();
		for(int i=0; i<n; i++){
			arr.add(new Pair(A[i] , 1));
		}
		for(int j=0; j<m; j++){
			arr.add(new Pair(B[j] , 0));
		}
		Collections.sort(arr);
		n++;
		m++;
		long ans = 0;
		for(Pair adj : arr){
			if(adj.second == 1){
				ans = (ans%mod + m*adj.first%mod)%mod;
				n--;
			}
			else{
				ans = (ans%mod + n*adj.first%mod)%mod;
				m--;
			}
		}
		return (int)ans;
	}

	class Pair implements Comparable < Pair > {
		int first;
		int second;
		public Pair(int a, int b) {
			this.first = a;
			this.second = b;
		}
		@Override
		public int compareTo(Pair temp) {
			if (this.first == temp.first)
				return this.second - temp.second;
			return this.first - temp.first;
		}
	}
}
