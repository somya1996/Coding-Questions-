package Array;

import java.util.Scanner;

public class Christmas_tree {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int A[] = new int[n];
		for(int i=0; i<n; i++){
			A[i] = sc.nextInt();
		}
		int B[] = new int[n];
		for(int i=0; i<n; i++){
			B[i] = sc.nextInt();
		}
		int ans = solve(A,B);
		System.out.println(ans);
	}
	public static int solve(int[] A, int[] B) {

		int mincost = Integer.MAX_VALUE;
		for(int q=1 ; q<A.length-1; q++){

			int minLcost = Integer.MAX_VALUE;
			for(int p = 0; p<q; p++){
				if(A[p] < A[q]){
					minLcost = Math.min(minLcost , B[p]);
				}
			}


			int minRcost = Integer.MAX_VALUE;
			for(int r = q+1; r<A.length; r++){
				if(A[q] < A[r]){
					minRcost = Math.min(minRcost , B[r]);
				}
			}

			if(minLcost!=Integer.MAX_VALUE && minRcost!=Integer.MAX_VALUE)
					mincost = Math.min(mincost , B[q]+minLcost+minRcost);

		}
		if(mincost == Integer.MAX_VALUE)
				return -1;
		return mincost;
	}
}
