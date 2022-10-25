package Heap;

import Array.medium_level.Kadanes_Algorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kth_smallest_element_in_sorted_matrix {
	public class Tuple{
		int val;
		int row;
		int col;
		Tuple(int value , int i , int j){
			val = value;
			row = i;
			col = j;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//int r = sc.nextInt();
		//int c = sc.nextInt();
		//int A[][] = new int[r][c];
		/*for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				A[i][j] = sc.nextInt();
			}
		}*/
		int[][] A = {{5,9,11},{9,11,13},{10,12,15},{13,14,16},{16,20,21}};
		int B = sc.nextInt();
		kth_smallest_element_in_sorted_matrix kse = new kth_smallest_element_in_sorted_matrix();
		int ans = kse.solve(A , B);
		System.out.println(ans);
	}
	public int solve(int[][] A, int B) {
		int rows = A.length;
		int cols = A[0].length;

		PriorityQueue<Tuple> pq = new PriorityQueue<>(Comparator.comparing(x->x.val));
		for(int i=0; i<rows; i++){
			pq.add(new Tuple(A[i][0] , i , 0));
		}
		for(int i=1; i<B; i++){
			Tuple t = pq.poll();
			if(t.col < cols-1){
				pq.add(new Tuple(A[t.row][t.col+1] , t.row , t.col+1));
			}
		}
		Tuple t = pq.poll();
		return t.val;
	}
}
