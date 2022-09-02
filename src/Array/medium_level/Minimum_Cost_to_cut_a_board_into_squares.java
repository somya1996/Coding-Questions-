package Array.medium_level;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Minimum_Cost_to_cut_a_board_into_squares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		int a = sc.nextInt();
		int X[] = new int[a];

		int b = sc.nextInt();
		int Y[] = new int[b];

		for(int i=0; i<a; i++)
			X[i] = sc.nextInt();

		for(int j=0; j<b; j++)
			Y[j] = sc.nextInt();

		int ans = minimumCostOfBreaking(X , Y ,  M , N);
		System.out.println(ans);
	}
	public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
		int cost = 0;
		int c = 1, r = 1;
		Arrays.sort(X); // sort the horizontal/column Array
		Arrays.sort(Y); // sort the vertical/row Array
		int i = X.length - 1;//Element present in horizontal X[]
		int j = Y.length - 1;//Element present in horizontal Y[]

		while (i >= 0 && j >= 0) {
			if (X[i] >= Y[j]) {
				cost += X[i] * r;
				c++;
				i--;
			}
			else{
				cost += Y[j] * c;
				r++;
				j--;
			}
		}
		while (i >= 0) {
			cost += X[i] * r;
			i--;
		}
		while (j >= 0) {
			cost += Y[j] * c;
			j--;
		}
		return cost;
	}
}
