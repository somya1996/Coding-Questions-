package Heap;

import java.util.Scanner;

/** can be done using 2 ways
 *  Comparators
 *  Heap / PriorityQueue
**/
public class B_closest_point_to_origin_B{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] A = new int[n][2];
		for(int i=0; i<n; i++){
			System.out.println("x");
			A[i][0] = sc.nextInt();
			System.out.println("y");
			A[i][1] = sc.nextInt();
		}

	}
}
