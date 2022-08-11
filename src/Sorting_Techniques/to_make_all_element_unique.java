package Sorting_Techniques;

import java.util.Arrays;
import java.util.Scanner;

public class to_make_all_element_unique {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int arr[] = new int[n];

		for(int i=0; i<n; i++){
			arr[i]  = sc.nextInt();
		}
		int ways = solve(arr);
		System.out.println(ways);
	}
	public static int solve(int[] A) {
		Arrays.sort(A);
		int previous = A[0];
		int step = 0;
		for(int i=1; i<A.length; i++){
			int current = A[i];
			if(previous >= current){
				//System.out.println("previous before "+previous);
				current = previous+1;
				//System.out.println("A[i] "+A[i]+" - " +current);

				step += (current - A[i]);


				A[i] = current;
				//System.out.println("previous after "+previous);

			}
			previous = current;


		}
		return step;
	}
}
