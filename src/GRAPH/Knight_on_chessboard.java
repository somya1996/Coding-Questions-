package GRAPH;

import java.util.*;

public class Knight_on_chessboard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int E = sc.nextInt();
		int F = sc.nextInt();
		Knight_on_chessboard koc = new Knight_on_chessboard();
		int ans = koc.knight(A , B , C , D , E , F);
		System.out.println(ans);
	}
	class Pair{
		int x_axis;
		int y_axis;
		int level;
		Pair(int x , int y , int l){
			x_axis = x;
			y_axis = y;
			level = l;
		}
	}
	public int knight(int A, int B, int C, int D, int E, int F) {
		int[][] vis = new int[A+1][B+1];
		Queue<Pair> pq = new LinkedList<>();
		pq.add(new Pair(C,D,0));

		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int x = p.x_axis;
			int y = p.y_axis;
			int l = p.level;
			if(x == E && y == F) return l;
			if(vis[x][y] == 1) continue;
			int dx[] = {-1, -2, -2 , -1 , +1 ,+2 , +2 ,+1};
			int dy[] = {-2, -1, +1 , +2 , +2, +1 , -1, -2};
			vis[x][y] = 1;
			for(int i=0; i<8; i++){
				int neigh_x = x + dx[i];
				int neigh_y = y + dy[i];
				if(neigh_x >= 0 && neigh_x < A && neigh_y >= 0 && neigh_y < B && vis[neigh_x][neigh_y] == 0){
					pq.add(new Pair(neigh_x , neigh_y , l+1));
				}
			}
		}
		return -1;
	}
}
