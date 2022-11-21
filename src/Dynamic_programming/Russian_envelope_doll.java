package Dynamic_programming;

import java.util.*;

public class Russian_envelope_doll {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] A = new int[n][2];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				A[i][j] = sc.nextInt();
			}
		}
		Russian_envelope_doll red = new Russian_envelope_doll();
		int ans = red.solve(A);
		System.out.println();
		System.out.println(ans);
	}
	class Pair{
		int width;
		int height;
		Pair(int w , int h){
			width = w;
			height = h;
		}
	}
	public int solve(int[][] A) {
		ArrayList<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < A.length; i++) {
			list.add(new Pair(A[i][0], A[i][1]));
		}
		for(int i=0; i<list.size(); i++){
			Pair p = list.get(i);
			System.out.println(p.width +" "+p.height);
		}
		Collections.sort(list, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if(p1.width == p2.width)
					return p1.height - p2.height;
				else
					return p1.width - p2.width;
			}
		});

		for(int i=0; i<list.size(); i++){
			Pair p = list.get(i);
			System.out.println(p.width +" "+p.height);
		}

		int dp[] = new int[list.size()];
		Arrays.fill(dp , 1);

		int max = 0;
		for(int i=0; i<A.length; i++){
			Pair p1 = list.get(i);
			for(int prev_index=0; prev_index<=i-1; prev_index++){
				Pair p2 = list.get(prev_index);
				if(p1.width > p2.width && p1.height > p2.height){
					dp[i] = Math.max(dp[i] , 1+dp[prev_index]);
				}
			}
		}

		for(int i=0; i<dp.length; i++){
			System.out.print("dp["+i+"] = " + dp[i] +" ");
			max = Math.max(max , dp[i]);
		}

		return max;
	}
}